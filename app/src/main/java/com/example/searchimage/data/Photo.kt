package com.example.searchimage.data

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    val id : Int?,
    @SerializedName("userImageURL")
    val userImageURL : String?
)
