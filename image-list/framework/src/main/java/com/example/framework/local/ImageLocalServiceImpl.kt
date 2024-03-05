package com.example.framework.local

import com.example.datasource.service.ImageLocalService
import com.example.domain.PhotoDetail
import com.example.framework.datastorage.PhotoDataStorage
import com.example.framework.datastorage.PhotoDataStorageImpl
import javax.inject.Inject

class ImageLocalServiceImpl @Inject constructor(val photoDataStorage: PhotoDataStorage) :
    ImageLocalService {


    override suspend fun insertPhotoListToLocal(photoList: List<PhotoDetail>) {
        val realmPhotoObjectList = mutableListOf<RealmPhotoObject>()
        photoList.map {
            realmPhotoObjectList.add(RealmPhotoObject().photoDetailToRealm(it))
        }
        photoDataStorage.insertPhotoListToDB(realmPhotoObjectList)
    }

    override suspend fun getPhotosFromLocal(): List<PhotoDetail> {
        val photoDetailList = mutableListOf<PhotoDetail>()
        photoDataStorage.readPhotoListFromDB().map {
            photoDetailList.add(RealmPhotoObject().realmToPhotoDetailObject(it))
        }
        return photoDetailList
    }


}