package com.hunguet123.searchImage.data.source.remote.api

import com.hunguet123.searchImage.data.model.PhotoResponse
import com.hunguet123.searchImage.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/")
    suspend fun getImages(
        @Query("q") q : String?,
        @Query("key") key: String = Constant.API_KEY,
        @Query("image_type") imageType : String = Constant.IMAGE_TYPE_PHOTO
    ) : PhotoResponse
}
