package com.example.datasource.network.network

import com.example.domain.Src
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SrcDTO(

    @SerialName("original")
    val original: String,

    @SerialName("large2x")
    val large2x: String,

    @SerialName("large")
    val large: String,

    @SerialName("medium")
    val medium: String,

    @SerialName("small")
    val small: String,

    @SerialName("portrait")
    val portrait: String,

    @SerialName("landscape")
    val landscape: String,

    @SerialName("tiny")
    val tiny: String
)

fun SrcDTO.toSrc(): Src {
    return Src(
        landscape = landscape,
        large = large,
        large2x = large2x,
        medium = medium,
        original = original,
        portrait = portrait,
        small = small,
        tiny = tiny
    )
}