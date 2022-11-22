package com.hunguet123.searchImage.data.di

import android.content.Context
import androidx.room.Room
import com.hunguet123.searchImage.data.source.local.room.PhotoRoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single { providePhotoRoomDatabase(androidContext()) }
}

private fun providePhotoRoomDatabase(context: Context) : PhotoRoomDatabase {
    return Room.databaseBuilder(context, PhotoRoomDatabase::class.java, "Photo.db")
        //.createFromAsset("database/photo.db")
        .build()
}
