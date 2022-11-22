package com.hunguet123.searchImage.data.source.local.room

import androidx.room.*
import com.hunguet123.searchImage.data.model.Photo


@Dao
interface PhotoDao {
    @Query("SELECT * FROM photoFavorite ORDER BY id")
    suspend fun getAllPhotos() : List<Photo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(photoLocal: Photo)

    @Query("DELETE FROM photoFavorite WHERE id = :id")
    suspend fun deleteById(id: Long)
}
