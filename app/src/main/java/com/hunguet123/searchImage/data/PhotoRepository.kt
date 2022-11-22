package com.hunguet123.searchImage.data

import com.hunguet123.searchImage.data.model.Photo
import com.hunguet123.searchImage.data.model.PhotoResponse

interface PhotoRepository {
    suspend fun getImages(q: String?) : List<Photo>?
    suspend fun getAllPhotos() : List<Photo>
    suspend fun insertPhoto(photo: Photo)
    suspend fun deletePhoto(id : Long)
}
