package com.hunguet123.searchImage.data.model

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("total")
    val total : Int,
    @SerializedName("totalHits")
    val totalHits : Int,
    @SerializedName("hits")
    val hits : List<Photo>?
)
