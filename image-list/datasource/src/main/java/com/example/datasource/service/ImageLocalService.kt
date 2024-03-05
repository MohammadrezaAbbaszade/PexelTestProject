package com.example.datasource.service

import com.example.domain.PhotoDetail

interface ImageLocalService {
    suspend fun insertPhotoListToLocal(photoList:List<PhotoDetail>)
    suspend fun getPhotosFromLocal():List<PhotoDetail>
}