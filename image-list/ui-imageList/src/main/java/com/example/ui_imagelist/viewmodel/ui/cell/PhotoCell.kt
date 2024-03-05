package com.example.ui_imagelist.viewmodel.ui.cell

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.component.ContactSubTitleCell
import com.example.component.R
import com.example.domain.PhotoDetail

class PhotoCell(context: Context) : ContactSubTitleCell(context) {



    init {
        middleSubTitle.visibility = GONE
        lastSubTitle.visibility = GONE
    }


    fun setData(photoDetail: PhotoDetail) {
        roomTitle.text = photoDetail.photographer
        Glide.with(context).asBitmap().load(photoDetail.src?.portrait).placeholder(
            ResourcesCompat.getDrawable(
            resources,
            R.drawable.drawable,
            null
        )).apply(
            RequestOptions.bitmapTransform(
                RoundedCorners(30)
            )).into(avatarImageView)
    }

}