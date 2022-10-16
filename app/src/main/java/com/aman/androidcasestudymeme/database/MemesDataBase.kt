package com.aman.androidcasestudymeme.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aman.androidcasestudymeme.modules.Meme

@Database(entities = [Meme::class], version = 1,exportSchema = false)
abstract class MemesDatabase : RoomDatabase() {

    abstract fun memeDao(): MemeDao?

    companion object {
        @Volatile
        var INSTANCE: MemesDatabase? = null

        fun getDatabase(context: Context): MemesDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MemesDatabase::class.java, "memes_database")
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}


