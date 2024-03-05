package com.example.pexeltestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigator.DestinationFragment
import com.example.navigator.NavigationHelper
import com.example.navigator.NavigationModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var fragmentArgs: HashMap<String, Any>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Navigator.navigate(
            R.id.nav_host_fragment,
            supportFragmentManager,
            NavigationModel(
                DestinationFragment.IMAGE_LIST_FRAGMENT,
                replace = true,
                addToBackStack = false,
                arg = fragmentArgs
            )
        )

    }
}