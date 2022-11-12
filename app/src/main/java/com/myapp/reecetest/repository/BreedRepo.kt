package com.myapp.reecetest.repository

import com.myapp.reecetest.model.BreedResponseItem
import com.myapp.reecetest.network.RetrofitBuilder

class BreedRepo {

    suspend fun getDogsBreed(): List<BreedResponseItem> = RetrofitBuilder.api.getAllBreed()

}