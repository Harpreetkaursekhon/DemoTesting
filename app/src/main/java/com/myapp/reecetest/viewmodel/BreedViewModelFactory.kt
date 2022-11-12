package com.myapp.reecetest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myapp.reecetest.repository.BreedRepo

class BreedViewModelFactory(private val breedRepo: BreedRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BreedViewModel(breedRepo) as T
    }
}