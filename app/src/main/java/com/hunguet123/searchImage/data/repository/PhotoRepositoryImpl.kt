package com.hunguet123.searchImage.data.repository

import com.hunguet123.searchImage.data.PhotoRepository
import com.hunguet123.searchImage.data.model.Photo
import com.hunguet123.searchImage.data.source.local.room.PhotoRoomDatabase
import com.hunguet123.searchImage.data.source.remote.api.ApiService

class PhotoRepositoryImpl(
    private val remote : ApiService,
    private val photoRoomDatabase: PhotoRoomDatabase
) : PhotoRepository {
    override suspend fun getImages(q: String?): List<Photo> {
        return remote.getImages(q).hits ?: emptyList()
    }

    override suspend fun getAllPhotos(): List<Photo> {
        return photoRoomDatabase.photoDao().getAllPhotos()
    }

    override suspend fun insertPhoto(photo: Photo) {
        photoRoomDatabase.photoDao().insertPhoto(photo)
    }

    override suspend fun deletePhoto(id : Long) {
        photoRoomDatabase.photoDao().deleteById(id)
    }

}
