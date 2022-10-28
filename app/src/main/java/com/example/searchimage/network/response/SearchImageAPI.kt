package com.example.searchimage.network.response

import com.example.searchimage.model.InformationResponseJson
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchImageAPI {
    @GET("/api/")
    suspend fun getImage(@Query("key") key: String ,@Query("q") q : String?, @Query("image_type") imageType : String?) : InformationResponseJson
}