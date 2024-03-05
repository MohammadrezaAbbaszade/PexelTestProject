package com.example.navigator

data class NavigationModel(
    val destinationFragment: DestinationFragment,
    val replace: Boolean,
    val addToBackStack : Boolean,
    val shouldBeVisible : Boolean = false,
    var arg: Map<String, Any>? = null
) {

}