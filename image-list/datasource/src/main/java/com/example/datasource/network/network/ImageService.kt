package com.example.datasource.network.network

import com.example.core.DataState
import com.example.domain.Photo
import kotlinx.coroutines.flow.Flow

interface ImageService {
    suspend fun getImageList(pageNumber:Int): Flow<DataState<Photo>>
}