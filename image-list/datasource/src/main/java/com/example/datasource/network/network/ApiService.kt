package com.example.datasource.network.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {


    @GET("curated")
    suspend fun getImages(
        @Header("Authorization") apiKey: String,
        @Query("page") pageNumber: Int,
        @Query("per_page") language: String = "15"
    ): Response<PhotosDTO>
}