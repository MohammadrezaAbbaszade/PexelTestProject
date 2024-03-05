package com.example.datasource.service

import com.example.core.DataState
import com.example.domain.Photo
import kotlinx.coroutines.flow.Flow

interface ImageRemoteService {
    suspend fun getImageList(pageNumber:Int): Flow<DataState<Photo>>
}