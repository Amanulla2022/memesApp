package com.aman.androidcasestudymeme.database

import com.aman.androidcasestudymeme.modules.Meme
import javax.inject.Inject

class MemeDaoImpl @Inject constructor(private val memeDao: MemeDao?) {

    suspend fun getAllMemes() : List<Meme> = memeDao!!.getAllMemes()

    suspend fun insertMeme(meme: List<Meme>) = memeDao!!.insertMeme(meme)

    suspend fun deleteMemes(meme: Meme) = memeDao!!.deleteMemes(meme)
}