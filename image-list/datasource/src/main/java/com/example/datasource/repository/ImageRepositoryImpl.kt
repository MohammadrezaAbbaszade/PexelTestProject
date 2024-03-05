package com.example.datasource.repository

import com.example.constants.EndPoints
import com.example.core.DataState
import com.example.core.ProgressBarState
import com.example.datasource.service.ImageLocalService
import com.example.datasource.service.ImageRemoteService
import com.example.domain.Photo
import com.example.domain.PhotoDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    val imageService: ImageRemoteService,
    val imageLocalService: ImageLocalService
) : ImageRepository {
    override suspend fun getImageList(pageNumber: Int): Flow<DataState<List<PhotoDetail>>> = flow {

        emit(DataState.Loading(progressBarState = ProgressBarState.Loading))
        imageService.getImageList(pageNumber).collect { photoData ->
            when (photoData) {
                is DataState.Data -> {
                    val photoList = mutableListOf<PhotoDetail>()
                    photoData.data?.let {
                        EndPoints.page = it.page
                        it.photos.map { photoDetail ->
                            photoDetail.page = it.page
                            photoList.add(photoDetail)
                        }
                        imageLocalService.insertPhotoListToLocal(photoList)
                    }

                    emit(DataState.Data(photoList))
                }

                is DataState.Response -> {
                    emit(DataState.Response(photoData.uiComponent))
                    val photoLocalList = imageLocalService.getPhotosFromLocal()
                    EndPoints.page = photoLocalList.last().page ?: 0
                    emit(DataState.Data(photoLocalList))
                }

                else -> {}
            }
        }


    }


}