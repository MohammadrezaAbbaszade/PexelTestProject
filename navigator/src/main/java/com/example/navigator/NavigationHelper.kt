package com.example.navigator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

object NavigationHelper {

    const val PHOTO_DETAIL_OBJECT = "com.example.ui_imagedetail.ui.PhotoDetail"

    val navigationFlow = MutableSharedFlow<NavigationModel>()
    fun navigateToDestination(
        destinationFragment: DestinationFragment,
        replace: Boolean,
        addToBackStack: Boolean,
        shouldBeVisible: Boolean = false,
        arg: Map<String, Any>? = null
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            navigationFlow.emit(
                NavigationModel(
                    destinationFragment,
                    replace,
                    addToBackStack,
                    shouldBeVisible,
                    arg
                )
            )
        }
    }

}