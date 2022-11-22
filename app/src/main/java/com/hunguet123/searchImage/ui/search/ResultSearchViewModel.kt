package com.hunguet123.searchImage.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hunguet123.searchImage.base.BaseViewModel
import com.hunguet123.searchImage.data.PhotoRepository
import com.hunguet123.searchImage.data.model.Photo
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ResultSearchViewModel : BaseViewModel(), KoinComponent {
    private val photoRepository : PhotoRepository by inject()
    val listImages = MutableLiveData<List<Photo>>()

    fun getImages(
        q : String?
    ) {
        viewModelScope.launch {
            try {
                //listImages.value = photoRepository.getImages(q)
                val listPhoto = photoRepository.getImages(q) ?: emptyList()
                val listPhotoLocal = photoRepository.getAllPhotos()
                val setListPhotoId = mutableSetOf<Long>()
                for (photoLocal in listPhotoLocal) {
                    setListPhotoId.add(photoLocal.id)
                }
                for (photo in listPhoto) {
                    if (setListPhotoId.contains(photo.id)) {
                        photo.favorite = true
                    }
                }
                listImages.value = listPhoto
            }
            catch (e : Exception) {
                error.value = e
            }
        }
    }

    fun insertPhoto(photo: Photo) {
        viewModelScope.launch {
            try {
                photoRepository.insertPhoto(photo)
            } catch (err : Exception) {
                error.value = err
            }
        }
    }

    fun deletePhotoFavorite(id : Long) {
        viewModelScope.launch {
            try {
                photoRepository.deletePhoto(id)
            } catch (err : Exception) {
                error.value = err
            }
        }
    }
}
