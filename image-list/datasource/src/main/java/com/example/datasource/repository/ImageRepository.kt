package com.example.datasource.repository

import com.example.core.DataState
import com.example.domain.Photo
import com.example.domain.PhotoDetail
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    suspend fun getImageList(pageNumber:Int): Flow<DataState<List<PhotoDetail>>>
}