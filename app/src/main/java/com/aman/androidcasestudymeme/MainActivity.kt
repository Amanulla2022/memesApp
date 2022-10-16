package com.aman.androidcasestudymeme

import RecyclerViewAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.aman.androidcasestudymeme.viewmodel.MemesViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.aman.androidcasestudymeme.modules.Meme
import com.aman.androidcasestudymeme.repository.MemesRepository
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   @Inject lateinit var memesRepository: MemesRepository
   lateinit var memesList: List<Meme>
    private  val postViewModel: MemesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)


        postViewModel.response.observe(this,Observer{
            val adapter = RecyclerViewAdapter(this,it )
          memesList =it
            viewPager.adapter = adapter
        })
        val next=findViewById<ImageView>(R.id.btnnext)
        next.setOnClickListener{
            viewPager.currentItem++
        }
        val prev=findViewById<ImageView>(R.id.btnprevious)
        prev.setOnClickListener{
            if(viewPager.currentItem==0){
                Toast.makeText(this,"This Meme is First One",Toast.LENGTH_SHORT).show()
            }
            else{
                viewPager.currentItem--
            }
        }
        val share = findViewById<ImageView>(R.id.sharebtn)
        share.setOnClickListener {
            postViewModel.response.observe(this){
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, " share this meme : ${it[viewPager.currentItem].name} ${it[viewPager.currentItem].url}")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }

        val delete = findViewById<ImageView>(R.id.deletebtn)
        delete.setOnClickListener {
            Toast.makeText(this, "This Meme is got deleted",Toast.LENGTH_LONG).show()
//            CoroutineScope(Dispatchers.IO).launch{
//                memesRepository.deleteMeme(memesList[viewPager.currentItem])
//            }
            val responsedata=postViewModel.responsedelete(memesList[viewPager.currentItem])
            responsedata.observe(this, Observer {
                val adapter2 = RecyclerViewAdapter(this,it )
                memesList = it
                viewPager.adapter = adapter2
            })
            memesRepository.deleteMeme(memesList[viewPager.currentItem])
            memesList[viewPager.currentItem++]
            }
        }
}
