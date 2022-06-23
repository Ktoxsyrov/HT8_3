package com.example.ht5_3

import kotlinx.serialization.Serializable


@Serializable
data class Cat(
    val id: String = "",
    val url: String = "",
)