package com.example.ui_imagelist.viewmodel.ui

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.PhotoDetail
import com.example.ui_imagelist.viewmodel.ui.cell.PhotoCell

class ImageListAdapter : RecyclerView.Adapter<ImageListAdapter.MovieListViewHolder>() {

    private var photoListItem = mutableListOf<PhotoDetail>()

    class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(PhotoCell(parent.context))
    }

    override fun getItemCount(): Int {
        return photoListItem.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movieItemCell = holder.itemView as PhotoCell
        val currentItem = photoListItem[position]
        movieItemCell.setData(currentItem)
    }

    fun addPhotoItems(movieItems: List<PhotoDetail>) {
        val firstIndex = photoListItem.size
        photoListItem.addAll(movieItems)
      notifyDataSetChanged()
    }
}