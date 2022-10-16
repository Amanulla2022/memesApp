import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aman.androidcasestudymeme.R
import com.aman.androidcasestudymeme.modules.Meme
import com.bumptech.glide.Glide

class RecyclerViewAdapter(val context: Context, val memes : List<Meme>): RecyclerView.Adapter<RecyclerViewAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meme_layout,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curMeme = memes[position]
        Glide.with(context).load(curMeme.url).into(holder.imageview)
        holder.title.text = curMeme.name
    }

    override fun getItemCount(): Int =memes.size

    class ViewPagerViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val imageview : ImageView = itemView.findViewById<ImageView>(R.id.memeimage)
        val title : TextView = itemView.findViewById(R.id.memeName)
    }

}