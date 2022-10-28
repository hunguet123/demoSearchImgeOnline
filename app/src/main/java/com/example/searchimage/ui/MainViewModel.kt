package com.example.searchimage.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchimage.model.InformationResponseJson
import com.example.searchimage.network.singleton.SearchImgApiSingleton
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val api = SearchImgApiSingleton.create()
    fun getPhotos(
        key : String,
        q : String?,
        imageType: String?,
        onLoadDataSuccess : (InformationResponseJson) -> Unit,
        onLoadDataFailure : (Throwable) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val responseJson = api.getImage(key , q, imageType)
                onLoadDataSuccess(responseJson)
            }
            catch (e : Exception) {
                onLoadDataFailure(e)
            }
        }
    }
}