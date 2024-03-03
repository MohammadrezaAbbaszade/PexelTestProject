package com.example.datasource

import com.example.domain.Photo
import com.example.domain.PhotoDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PhotosDTO(

    @SerialName("page")
    val page: Int,

    @SerialName("per_page")
    val perPage: Int,

    @SerialName("photos")
    val photos: List<PhotoDetailDTO>,

    @SerialName("next_page")
    val nextPage: String
)

fun PhotosDTO.toPhoto(): Photo {
    return Photo(
        next_page = nextPage,
        page = page,
        per_page = perPage,
        photos = createPhotoList(photos)
    )
}

fun createPhotoList(photoList: List<PhotoDetailDTO>): List<PhotoDetail> {
    val photoDetailList = mutableListOf<PhotoDetail>()
    photoList.forEach {
        photoDetailList.add(it.toPhotoDetail())
    }

    return photoDetailList
}