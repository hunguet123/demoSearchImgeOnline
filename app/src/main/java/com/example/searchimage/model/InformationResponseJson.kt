package com.example.searchimage.model

import com.example.searchimage.data.Photo
import com.google.gson.annotations.SerializedName

data class InformationResponseJson(
    @SerializedName("total")
    val total : Int,
    @SerializedName("totalHits")
    val totalHits : Int,
    @SerializedName("hits")
    val hits : List<Photo>?
)
