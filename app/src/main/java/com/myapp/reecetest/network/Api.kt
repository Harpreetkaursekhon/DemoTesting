package com.myapp.reecetest.network

import com.myapp.reecetest.model.BreedResponse
import com.myapp.reecetest.model.BreedResponseItem
import retrofit2.http.GET

interface Api {

    @GET("v1/breeds")
    suspend fun getAllBreed(): List<BreedResponseItem>

}