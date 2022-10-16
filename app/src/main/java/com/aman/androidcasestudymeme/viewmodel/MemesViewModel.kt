package com.aman.androidcasestudymeme.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.aman.androidcasestudymeme.modules.Meme
import com.aman.androidcasestudymeme.repository.MemesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemesViewModel @Inject constructor(private val memeRepository: MemesRepository): ViewModel() {

    val response : LiveData<List<Meme>> = memeRepository.getMeme()
        .catch {  error->
            Log.d("tag"," Error : ${error.message}")
        }.asLiveData( )

    fun responsedelete(meme:Meme):LiveData<List<Meme>> = memeRepository.deleteMeme(meme)
        .catch {

    }.asLiveData()

}