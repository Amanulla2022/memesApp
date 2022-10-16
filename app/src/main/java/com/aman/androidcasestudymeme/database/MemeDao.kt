package com.aman.androidcasestudymeme.database

import androidx.room.*
import com.aman.androidcasestudymeme.modules.Meme

@Dao
interface MemeDao {

    @Query("SELECT * FROM memes")
    suspend fun getAllMemes(): List<Meme>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeme(meme: List<Meme>)

    @Delete
    suspend fun deleteMemes(meme: Meme)


}