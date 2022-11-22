package com.hunguet123.searchImage.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hunguet123.searchImage.data.model.Photo

@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class PhotoRoomDatabase : RoomDatabase() {
    abstract fun photoDao() : PhotoDao
}
