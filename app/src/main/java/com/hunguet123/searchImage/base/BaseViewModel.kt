package com.hunguet123.searchImage.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel(){
    val error = MutableLiveData<Exception>()
}
