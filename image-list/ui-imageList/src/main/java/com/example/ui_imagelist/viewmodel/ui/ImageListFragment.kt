package com.example.ui_imagelist.viewmodel.ui

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.constants.EndPoints
import com.example.core.DataState
import com.example.core.UiComponent
import com.example.navigator.DestinationFragment
import com.example.navigator.NavigationHelper
import com.example.ui_imagelist.viewmodel.viewmodel.ImageListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ImageListFragment : Fragment() {

    val photoListViewModel: ImageListViewModel by viewModels()
    lateinit var rootView: FrameLayout
    lateinit var progressBar: ProgressBar
    lateinit var imageRecyclerView: RecyclerView
    lateinit var imageListAdapter: ImageListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = FrameLayout(requireContext())

        imageRecyclerView = RecyclerView(requireContext()).apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }

        rootView.addView(
            imageRecyclerView,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        )
        imageListAdapter = ImageListAdapter()
        imageRecyclerView.adapter = imageListAdapter

        progressBar = ProgressBar(requireContext()).apply {
            this.visibility = View.GONE
        }
        rootView.addView(
            progressBar, FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER
            )
        )
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photoListViewModel.getImageList(1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photoListViewModel.photoItemsObserver.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Data -> {
                    imageListAdapter.addPhotoItems(dataState.data!!)
                    progressBar.visibility = View.GONE
                }

                is DataState.Response -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        (dataState.uiComponent as UiComponent.Dialog).description,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is DataState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }

                else -> {}
            }
        }

        imageListAdapter.onItemClicked = { photoDetail ->
            val args = HashMap<String, Any>()
            args[NavigationHelper.PHOTO_DETAIL_OBJECT] = photoDetail
            NavigationHelper.navigateToDestination(
                DestinationFragment.IMAGE_DETAIL_FRAGMENT,
                replace = false,
                addToBackStack = true,
                arg = args
            )

        }

        imageRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == imageListAdapter.itemCount - 1) {
                    progressBar.visibility = View.VISIBLE
                    photoListViewModel.getImageList(EndPoints.page + 1)
                }
            }
        })

    }
}