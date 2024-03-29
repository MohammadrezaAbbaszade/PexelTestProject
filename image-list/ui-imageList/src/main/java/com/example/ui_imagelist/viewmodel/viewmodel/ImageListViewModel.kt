package com.example.ui_imagelist.viewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.DataState
import com.example.domain.PhotoDetail
import com.example.usecase.GetImages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(val getImages: GetImages) : ViewModel() {

    private val _photoItemsObserver = MutableLiveData<DataState<List<PhotoDetail>>>()
    val photoItemsObserver: LiveData<DataState<List<PhotoDetail>>> = _photoItemsObserver

    fun getImageList(pageNumber: Int) {
        viewModelScope.launch {
            getImages.execute(pageNumber).collect {
                _photoItemsObserver.value = it
            }
        }

    }


}