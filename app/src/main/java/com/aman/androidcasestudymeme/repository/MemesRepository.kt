package com.aman.androidcasestudymeme.repository


import com.aman.androidcasestudymeme.modules.Meme
import com.aman.androidcasestudymeme.database.MemeDaoImpl
import com.aman.androidcasestudymeme.network.MemeServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MemesRepository @Inject constructor(private val apiService: MemeServiceImpl,
                                          private val memeDaoImpl: MemeDaoImpl
){

    fun getMeme() : Flow<List<Meme>> = flow {
        var allListmemes=memeDaoImpl.getAllMemes();//data from the Db
        if(allListmemes.size>0)
        {
          emit(allListmemes)
        }else {
            val response = apiService.getMeme()
            memeDaoImpl.insertMeme(response.body()?.memeList!!.memes)
           allListmemes=memeDaoImpl.getAllMemes()
            emit(allListmemes);
        }
        }.flowOn(Dispatchers.IO)

        fun deleteMeme(meme: Meme):Flow<List<Meme>> = flow {
          var deletememe= memeDaoImpl.deleteMemes(meme)
            var allListmeme=memeDaoImpl.getAllMemes()

                emit(allListmeme)
       }
}