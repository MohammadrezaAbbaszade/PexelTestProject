package com.example.framework.datastorage


import com.example.framework.local.RealmPhotoObject
import io.realm.Realm
import javax.inject.Inject

class PhotoDataStorageImpl @Inject constructor(val realm: Realm) : PhotoDataStorage {
    override suspend fun insertPhotoListToDB(photos: List<RealmPhotoObject>) {
        try {
            realm.beginTransaction()
            photos.map { inputPhoto ->
                var photo: RealmPhotoObject? =
                    realm.where(RealmPhotoObject::class.java).equalTo("id", inputPhoto.id)
                        .findFirst()

                if (photo == null) {
                    photo = realm.createObject(RealmPhotoObject::class.java, inputPhoto.id)
                }


                photo?.let {
                    photo.alt = inputPhoto.alt
                    photo.avg_color = inputPhoto.avg_color
                    photo.photographer = inputPhoto.photographer
                    photo.photographer_url = inputPhoto.photographer_url
                    photo.photographer_id = inputPhoto.photographer_id
                    photo.width = inputPhoto.width
                    photo.height = inputPhoto.height
                    photo.url = inputPhoto.url
                    photo.liked = inputPhoto.liked
                    photo.lastPage = inputPhoto.lastPage
                    photo.src = realm.copyToRealm(inputPhoto.src!!)
                }
            }


            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    override suspend fun readPhotoListFromDB(): List<RealmPhotoObject> {
        var listToReturn = mutableListOf<RealmPhotoObject>()
        try {
            listToReturn = realm.where(RealmPhotoObject::class.java).findAll()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return listToReturn
    }


}