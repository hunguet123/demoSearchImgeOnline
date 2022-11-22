package com.hunguet123.searchImage.data.di

import com.hunguet123.searchImage.data.PhotoRepository
import com.hunguet123.searchImage.data.repository.PhotoRepositoryImpl

import org.koin.dsl.module

val repositoryModule = module {
    single<PhotoRepository> {
        PhotoRepositoryImpl(remote = get(), photoRoomDatabase = get())
    }
}
