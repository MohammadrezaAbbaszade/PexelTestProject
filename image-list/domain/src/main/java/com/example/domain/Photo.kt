package com.example.domain

data class Photo(
    val next_page: String?,
    val page: Int,
    val per_page: Int,
    val photos: List<PhotoDetail>
)
