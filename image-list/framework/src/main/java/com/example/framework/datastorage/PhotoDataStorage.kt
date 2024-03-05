package com.example.framework.datastorage

import com.example.framework.local.RealmPhotoObject

interface PhotoDataStorage {

    suspend fun insertPhotoListToDB(photos:List<RealmPhotoObject>)
    suspend fun readPhotoListFromDB():List<RealmPhotoObject>
}