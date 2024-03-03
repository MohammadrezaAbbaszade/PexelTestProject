package com.example.datasource

import com.example.domain.PhotoDetail
import com.example.domain.Src
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoDetailDTO(
    @SerialName("id")
    val id: Int,

    @SerialName("width")
    val width: Int,

    @SerialName("height")
    val height: Int,

    @SerialName("url")
    val url: String,

    @SerialName("photographer")
    val photographer: String,

    @SerialName("photographer_url")
    val photographerUrl: String,

    @SerialName("photographer_id")
    val photographerId: Int,

    @SerialName("avg_color")
    val avgColor: String,

    @SerialName("src")
    val src: SrcDTO,

    @SerialName("liked")
    val liked: Boolean,

    @SerialName("alt")
    val alt: String
)

fun PhotoDetailDTO.toPhotoDetail(): PhotoDetail {
    return PhotoDetail(
        alt = alt,
        avg_color = avgColor,
        height = height,
        id = id,
        liked = liked,
        photographer = photographer,
        photographer_id = photographerId,
        photographer_url =photographerUrl,
        url = url,
        width = width,
        src = createSrc(src)
    )
}


fun createSrc(srcDTO: SrcDTO): Src {
    return Src(
        landscape = srcDTO.landscape,
        large = srcDTO.large,
        large2x = srcDTO.large2x,
        medium = srcDTO.medium,
        original = srcDTO.original,
        portrait = srcDTO.portrait,
        small = srcDTO.small,
        tiny = srcDTO.tiny
    )
}