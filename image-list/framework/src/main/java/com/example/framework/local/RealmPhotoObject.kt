package com.example.framework.local

import com.example.domain.PhotoDetail
import com.example.domain.Src
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmPhotoObject(
    @PrimaryKey
    var id: Int? = null,
    var alt: String? = null,
    var avg_color: String? = null,
    var height: Int? = null,
    var liked: Boolean? = null,
    var photographer: String? = null,
    var photographer_id: Int? = null,
    var photographer_url: String? = null,
    var src: RealmSrcObject? = null,
    var url: String? = null,
    var width: Int? = null
) : RealmObject()


fun RealmPhotoObject.photoDetailToRealm(photoDetail: PhotoDetail): RealmPhotoObject {
    return RealmPhotoObject(
        id = photoDetail.id,
        alt = photoDetail.alt,
        avg_color = photoDetail.avg_color,
        height = photoDetail.height,
        width = photoDetail.width,
        photographer = photoDetail.photographer,
        photographer_url = photoDetail.photographer_url,
        photographer_id = photoDetail.photographer_id,
        url = photoDetail.url,
        liked = photoDetail.liked,
        src = RealmSrcObject().srcObjectToRealmSrcObject(photoDetail.src!!)
    )
}

fun RealmPhotoObject.realmToPhotoDetailObject(realmPhotoObject: RealmPhotoObject): PhotoDetail {
    return PhotoDetail(
        id = realmPhotoObject.id,
        alt = realmPhotoObject.alt,
        avg_color = realmPhotoObject.avg_color,
        height = realmPhotoObject.height,
        width = realmPhotoObject.width,
        photographer = realmPhotoObject.photographer?:"",
        photographer_url = realmPhotoObject.photographer_url,
        photographer_id = realmPhotoObject.photographer_id,
        url = realmPhotoObject.url,
        liked = realmPhotoObject.liked,
        src = RealmSrcObject().realmSrcObjectToSrc(realmPhotoObject.src!!)
    )
}