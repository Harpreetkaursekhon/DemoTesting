package com.myapp.reecetest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.reecetest.model.BreedResponseItem
import com.myapp.reecetest.repository.BreedRepo
import kotlinx.coroutines.launch
import java.lang.Exception

class BreedViewModel(private val breedRepo: BreedRepo): ViewModel() {

     val response : MutableLiveData<List<BreedResponseItem>> = MutableLiveData()

    fun getBreedData(){
        viewModelScope.launch {
            try {
                response.value= breedRepo.getDogsBreed()
            }
            catch (e: Exception)
            {
                e.printStackTrace()
            }
        }

    }

}