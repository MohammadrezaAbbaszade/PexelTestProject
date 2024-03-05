package com.example.ui_imagedetail.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.component.addConstraintSet
import com.example.component.addViewToConstraintLayout
import com.example.component.dp
import com.example.component.matchParent
import com.example.component.wrapContent
import com.example.domain.PhotoDetail
import com.example.navigator.NavigationHelper

class ImageDetailFragment : Fragment() {

    lateinit var rootView: ConstraintLayout
    lateinit var progressBar: ProgressBar

    lateinit var photoImageView: ImageView

    lateinit var photographerTitle: TextView
    lateinit var photographerText: TextView

    lateinit var heightTitle: TextView
    lateinit var heightText: TextView

    lateinit var widthTitle: TextView
    lateinit var widthText: TextView

    lateinit var likedTitle: TextView
    lateinit var likedText: TextView

    lateinit var altTitle: TextView
    lateinit var altText: TextView

    lateinit var photoDetail: PhotoDetail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photoDetail =
            arguments?.getSerializable(NavigationHelper.PHOTO_DETAIL_OBJECT) as PhotoDetail
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = ConstraintLayout(requireContext()).apply {
            this.id = View.generateViewId()
            this.layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
            this.setBackgroundColor(Color.WHITE)
        }
        progressBar = ProgressBar(requireContext()).apply {
            this.id = View.generateViewId()
        }
        photoImageView = ImageView(requireContext()).apply {
            this.id = View.generateViewId()
            this.scaleType = ImageView.ScaleType.CENTER_INSIDE
        }

        photographerTitle = TextView(requireContext()).apply {
            this.id = View.generateViewId()
            this.setTextColor(
                Color.BLACK
            )
            this.text = "Photographer:"
            setTypeface(this.typeface, Typeface.BOLD)
        }

        photographerText = TextView(requireContext()).apply {
            this.id = View.generateViewId()
            this.setTextColor(
                Color.BLACK
            )
        }

        heightTitle = TextView(requireContext()).apply {
            this.id = View.generateViewId()
            this.setTextColor(
                Color.BLACK
            )
            this.text = "Height:"
            setTypeface(this.typeface, Typeface.BOLD)
        }

        heightText = TextView(requireContext()).apply {
            this.id = View.generateViewId()
            this.setTextColor(
                Color.BLACK
            )
        }


        widthTitle = TextView(requireContext()).apply {
            this.id = View.generateViewId()
            this.setTextColor(
                Color.BLACK
            )
            this.text = "Width:"
            setTypeface(this.typeface, Typeface.BOLD)
        }

        widthText = TextView(requireContext()).apply {
            this.id = View.generateViewId()
            this.setTextColor(
                Color.BLACK
            )
        }

        likedTitle = TextView(requireContext()).apply {
            this.id = View.generateViewId()
            this.setTextColor(
                Color.BLACK
            )
            this.text = "Liked:"
            setTypeface(this.typeface, Typeface.BOLD)
        }

        likedText = TextView(requireContext()).apply {
            this.id = View.generateViewId()
            this.setTextColor(
                Color.BLACK
            )
        }

        altTitle = TextView(requireContext()).apply {
            this.id = View.generateViewId()
            this.setTextColor(
                Color.BLACK
            )
            this.text = "Alt:"
            setTypeface(this.typeface, Typeface.BOLD)
        }

        altText = TextView(requireContext()).apply {
            this.id = View.generateViewId()
            this.setTextColor(
                Color.BLACK
            )
            this.isSingleLine = true
            ellipsize = TextUtils.TruncateAt.END
        }


        addViewToConstraintLayout(rootView, progressBar)
        addViewToConstraintLayout(rootView, photoImageView)
        addViewToConstraintLayout(rootView, photographerTitle)
        addViewToConstraintLayout(rootView, photographerText)
        addViewToConstraintLayout(rootView, heightTitle)
        addViewToConstraintLayout(rootView, heightText)
        addViewToConstraintLayout(rootView, widthTitle)
        addViewToConstraintLayout(rootView, widthText)
        addViewToConstraintLayout(rootView, likedTitle)
        addViewToConstraintLayout(rootView, likedText)
        addViewToConstraintLayout(rootView, altTitle)
        addViewToConstraintLayout(rootView, altText)



        addConstraintSet(
            photoImageView.id,
            300.dp(),
            matchParent,
            topToTop = rootView.id,
            endToEnd = rootView.id,
            startToStart = rootView.id,
            parentView = rootView
        )

        addConstraintSet(
            progressBar.id,
            wrapContent,
            wrapContent,
            topToTop = photoImageView.id,
            endToEnd = photoImageView.id,
            startToStart = photoImageView.id,
            bottomToBottom = photoImageView.id,
            parentView = rootView
        )

        addConstraintSet(
            photographerTitle.id,
            wrapContent,
            wrapContent,
            marginStart = 8.dp(),
            marginTop = 8.dp(),
            topToBottom = photoImageView.id,
            startToStart = rootView.id,
            parentView = rootView
        )

        addConstraintSet(
            photographerText.id,
            wrapContent,
            0,
            marginStart = 4.dp(),
            topToTop = photographerTitle.id,
            startToEnd = photographerTitle.id,
            bottomToBottom = photographerTitle.id,
            endToEnd = rootView.id,
            parentView = rootView
        )

        addConstraintSet(
            heightTitle.id,
            wrapContent,
            wrapContent,
            topToBottom = photographerTitle.id,
            startToStart = photographerTitle.id,
            parentView = rootView
        )

        addConstraintSet(
            heightText.id,
            wrapContent,
            0,
            marginStart = 4.dp(),
            topToTop = heightTitle.id,
            startToEnd = heightTitle.id,
            bottomToBottom = heightTitle.id,
            endToEnd = rootView.id,
            parentView = rootView
        )


        addConstraintSet(
            widthTitle.id,
            wrapContent,
            wrapContent,
            topToBottom = heightTitle.id,
            startToStart = heightTitle.id,
            parentView = rootView
        )

        addConstraintSet(
            widthText.id,
            wrapContent,
            0,
            marginStart = 4.dp(),
            topToTop = widthTitle.id,
            startToEnd = widthTitle.id,
            bottomToBottom = widthTitle.id,
            endToEnd = rootView.id,
            parentView = rootView
        )


        addConstraintSet(
            likedTitle.id,
            wrapContent,
            wrapContent,
            topToBottom = widthTitle.id,
            startToStart = widthTitle.id,
            parentView = rootView
        )

        addConstraintSet(
            likedText.id,
            wrapContent,
            0,
            marginStart = 4.dp(),
            topToTop = likedTitle.id,
            startToEnd = likedTitle.id,
            bottomToBottom = likedTitle.id,
            endToEnd = rootView.id,
            parentView = rootView
        )


        addConstraintSet(
            altTitle.id,
            wrapContent,
            wrapContent,
            topToBottom = likedTitle.id,
            startToStart = likedTitle.id,
            parentView = rootView
        )

        addConstraintSet(
            altText.id,
            wrapContent,
            0,
            marginStart = 4.dp(),
            topToTop = altTitle.id,
            startToEnd = altTitle.id,
            bottomToBottom = altTitle.id,
            endToEnd = rootView.id,
            parentView = rootView
        )

        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(photoDetail.src?.landscape)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }

            }).centerInside()
            .into(photoImageView)

        photographerText.text = photoDetail.photographer
        heightText.text = photoDetail.height.toString()
        widthText.text = photoDetail.width.toString()
        likedText.text = photoDetail.liked.toString()
        altText.text = photoDetail.alt
    }
}