package com.aman.androidcasestudymeme.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.aman.androidcasestudymeme.modules.Meme
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class MemeDaoTest {
    private lateinit var database: MemesDatabase
    private lateinit var dao: MemeDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MemesDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.memeDao()!!
    }
    @After
    fun teardown(){
        database.close()
    }
    @Test
    fun getAllMemes() = runBlocking {
        val Item1=Meme("181913649",2,1200,"Drake Hotline Bling","https://i.imgflip/30b1gx.jpg",1200 )
        val Item2=Meme("181913649",2,1200,"Drake Hotline Bling","https://i.imgflip/30b1gx.jpg",1200 )
        val listMeme:List<Meme> = mutableListOf(Item1,Item2)
        dao.insertMeme(listMeme)
        val totalItems=dao.getAllMemes()
        assert(totalItems.isNotEmpty())

    }
    @Test
    fun insertMeme()= runBlocking {
        val Item1=Meme("181913649",2,1200,"Drake Hotline Bling","https://i.imgflip/30b1gx.jpg",1200 )
        val Item2=Meme("181913649",2,1200,"Drake Hotline Bling","https://i.imgflip/30b1gx.jpg",1200 )
        val listMeme:List<Meme> = mutableListOf(Item1,Item2)
        dao.insertMeme(listMeme)
        val getMemeItems=dao.getAllMemes()
        val byName=dao.getAllMemes()
        assert(byName.size == getMemeItems.size)
    }
    @Test
    fun deleteMemes()= runBlocking {
        val Item1=Meme("181913649",2,1200,"Drake Hotline Bling","https://i.imgflip/30b1gx.jpg",1200 )
        val Item2=Meme("181913649",2,1200,"Drake Hotline Bling","https://i.imgflip/30b1gx.jpg",1200 )
        val listMeme:List<Meme> = mutableListOf(Item1,Item2)
        dao.deleteMemes(Item1)
        assert(listMeme.contains(Item2))
    }
}