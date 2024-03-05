package com.example.domain

import java.io.Serializable

data class PhotoDetail(
    val alt: String?,
    val avg_color: String?,
    val height: Int?,
    val id: Int?,
    var page: Int? = 0,
    val liked: Boolean?,
    val photographer: String,
    val photographer_id: Int?,
    val photographer_url: String?,
    val src: Src?,
    val url: String?,
    val width: Int?
) : Serializable

