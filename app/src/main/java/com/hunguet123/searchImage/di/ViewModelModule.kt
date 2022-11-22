package com.hunguet123.searchImage.di

import com.hunguet123.searchImage.ui.favorite.FavoriteViewModel
import com.hunguet123.searchImage.ui.search.ResultSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ResultSearchViewModel()
    }
    viewModel {
        FavoriteViewModel()
    }
}
