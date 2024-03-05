package com.example.usecase

import com.example.constants.EndPoints
import com.example.core.DataState
import com.example.core.ProgressBarState
import com.example.core.UiComponent
import com.example.datasource.network.network.ImageService
import com.example.domain.Photo
import com.example.domain.PhotoDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class GetImages(private val imageService: ImageService) {

    fun execute(pageNumber: Int): Flow<DataState<List<PhotoDetail>>> = flow {

        emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

        val photoData = imageService.getImageList(pageNumber).first()
        when (photoData) {
            is DataState.Data -> {
                val photoList = mutableListOf<PhotoDetail>()
                photoData.data?.let {
                    EndPoints.page = it.page
                    it.photos.map {
                        photoList.add(it)
                    }
                }
                emit(DataState.Data(photoList))
            }

            is DataState.Response -> {
                emit(DataState.Response(photoData.uiComponent))
            }

            else -> {}
        }

    }
}