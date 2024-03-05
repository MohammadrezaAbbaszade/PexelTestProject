package com.example.framework.remote
import com.example.domain.PhotoDetail
import com.example.domain.Src
import com.example.framework.local.RealmPhotoObject
import com.example.framework.local.RealmSrcObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PhotoDetailDTO(
    @SerialName("id")
    val id: Int? = null,

    @SerialName("width")
    val width: Int? = null,

    @SerialName("height")
    val height: Int? = null,

    @SerialName("url")
    val url: String? = null,

    @SerialName("photographer")
    val photographer: String? = null,

    @SerialName("photographer_url")
    val photographerUrl: String? = null,

    @SerialName("photographer_id")
    val photographerId: Int? = null,

    @SerialName("avg_color")
    val avgColor: String? = null,

    @SerialName("src")
    val src: SrcDTO? = null,

    @SerialName("liked")
    val liked: Boolean? = null,

    @SerialName("alt")
    val alt: String? = null
)

fun PhotoDetailDTO.toPhotoDetail(): PhotoDetail {
    return PhotoDetail(
        alt = alt,
        avg_color = avgColor ?: "",
        height = height ?: 0,
        id = id ?: 0,
        liked = liked ?: false,
        photographer = photographer ?: "",
        photographer_id = photographerId ?: 0,
        photographer_url = photographerUrl ?: "",
        url = url ?: "",
        width = width ?: 0,
        src = createSrc(src)
    )
}


fun createSrc(srcDTO: SrcDTO?): Src {
    return Src(
        landscape = srcDTO?.landscape?:"",
        large = srcDTO?.large?:"",
        large2x = srcDTO?.large2x?:"",
        medium = srcDTO?.medium?:"",
        original = srcDTO?.original?:"",
        portrait = srcDTO?.portrait?:"",
        small = srcDTO?.small?:"",
        tiny = srcDTO?.tiny?:""
    )
}

fun PhotoDetailDTO.toRealmPhotoObject(): RealmPhotoObject {
    return RealmPhotoObject(
        alt = alt,
        avg_color = avgColor ?: "",
        height = height ?: 0,
        id = id ?: 0,
        liked = liked ?: false,
        photographer = photographer ?: "",
        photographer_id = photographerId ?: 0,
        photographer_url = photographerUrl ?: "",
        url = url ?: "",
        width = width ?: 0,
        src = createRealmSrcObject(src)
    )
}


fun createRealmSrcObject(srcDTO: SrcDTO?): RealmSrcObject {
    return RealmSrcObject(
        landscape = srcDTO?.landscape?:"",
        large = srcDTO?.large?:"",
        large2x = srcDTO?.large2x?:"",
        medium = srcDTO?.medium?:"",
        original = srcDTO?.original?:"",
        portrait = srcDTO?.portrait?:"",
        small = srcDTO?.small?:"",
        tiny = srcDTO?.tiny?:""
    )
}