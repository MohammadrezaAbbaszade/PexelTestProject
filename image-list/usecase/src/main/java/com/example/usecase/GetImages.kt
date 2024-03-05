package com.example.usecase

import com.example.constants.EndPoints
import com.example.core.DataState
import com.example.core.ProgressBarState
import com.example.datasource.repository.ImageRepository
import com.example.domain.PhotoDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class GetImages(private val imageRepository: ImageRepository) {

    suspend fun execute(pageNumber: Int): Flow<DataState<List<PhotoDetail>>> {
        return imageRepository.getImageList(pageNumber)
    }
}