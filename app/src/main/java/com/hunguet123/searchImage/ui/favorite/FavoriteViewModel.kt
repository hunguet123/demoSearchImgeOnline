package com.hunguet123.searchImage.ui.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hunguet123.searchImage.base.BaseViewModel
import com.hunguet123.searchImage.data.PhotoRepository
import com.hunguet123.searchImage.data.model.Photo
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FavoriteViewModel : BaseViewModel(), KoinComponent {
    private val photoRepository : PhotoRepository by inject()

    val photosFavorite = MutableLiveData<List<Photo>>()

    fun getPhotosFavorite() {
        viewModelScope.launch {
            try {
                photosFavorite.value = photoRepository.getAllPhotos()
            } catch (err : Exception) {
                error.value = err
            }
        }
    }

    fun deletePhotoFavorite(id : Long) {
        viewModelScope.launch {
            try {
                photoRepository.deletePhoto(id)
                photosFavorite.value = photoRepository.getAllPhotos()
            } catch (err : Exception) {
                error.value = err
            }
        }
    }
}
