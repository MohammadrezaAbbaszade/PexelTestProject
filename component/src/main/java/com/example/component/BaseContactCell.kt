package com.example.component

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Guideline
import androidx.core.content.res.ResourcesCompat


abstract class BaseContactCell(
    context: Context,
) : ConstraintLayout(context) {

    lateinit var avatarImageView: ImageView
    lateinit var roomTitleWithIcons: ConstraintLayout
    lateinit var roomTitle: TextView
    lateinit var dividerLine: View

    lateinit var verticalGuideLine: Guideline

    init {
        val lp = LayoutParams(matchParent, wrapContent)
        layoutParams = lp
        id = View.generateViewId()

        verticalGuideLine = getNewGuideline(context, LayoutParams.VERTICAL)
        verticalGuideLine.setGuidelinePercent(0.2F)
        addView(verticalGuideLine)


        avatarImageView = ImageView(context).apply {
            this.id = View.generateViewId()
            this.elevation = 5f
            this.scaleType = ImageView.ScaleType.FIT_XY
        }

        roomTitleWithIcons = ConstraintLayout(context).apply {
            this.id = View.generateViewId()
            val roomTitleWithIconsLayoutParams =
                LayoutParams(wrapContent, wrapContent)
            this.layoutParams = roomTitleWithIconsLayoutParams
        }

        roomTitle = TextView(context).apply {
            this.id = View.generateViewId()
            setTextColor(Color.BLACK)
            textSize = 14f
            gravity = Gravity.RIGHT or Gravity.CENTER
            isSingleLine = true
            setTypeface(this.typeface, Typeface.BOLD)
            ellipsize = TextUtils.TruncateAt.END
        }


        dividerLine = View(context).apply {
            this.id = View.generateViewId()
            this.setBackgroundColor(Color.parseColor("#EFEFF1"))
        }


        addViewToConstraintLayout(this, avatarImageView)
        addViewToConstraintLayout(this, roomTitleWithIcons)
        addViewToConstraintLayout(roomTitleWithIcons, roomTitle)
        addViewToConstraintLayout(this, dividerLine)

        addConstraintSet(
            avatarImageView.id,
            100.dp(),
            100.dp(),
            topToTop = this.id,
            endToEnd = this.id,
            bottomToTop = dividerLine.id,
            marginEnd = 12.dp(),
            marginTop = 8.dp(),
            marginBottom = 8.dp(),
            verticalBias = 0f,
            goneMarginLeft = 8.dp(),
            parentView = this
        )

        addConstraintSet(
            roomTitleWithIcons.id,
            wrapContent,
            wrapContent,
            bottomToBottom = avatarImageView.id,
            endToStart = avatarImageView.id,
            startToEnd = verticalGuideLine.id,
            topToTop = avatarImageView.id,
            defaultWidth = ConstraintSet.MATCH_CONSTRAINT_WRAP,
            verticalChainStyle = ConstraintSet.CHAIN_PACKED,
            marginEnd = 12.dp(),
            horizontalBias = 1f,
            parentView = this
        )
        setConstraintWidth(true, roomTitleWithIcons)


        addConstraintSet(
            roomTitle.id,
            wrapContent,
            wrapContent,
            topToTop = roomTitleWithIcons.id,
            endToEnd = roomTitleWithIcons.id,
            startToStart = roomTitleWithIcons.id,
            bottomToBottom = roomTitleWithIcons.id,
            horizontalBias = 1f,
            parentView = roomTitleWithIcons
        )
        setConstraintWidth(true, roomTitle)


        addConstraintSet(
            dividerLine.id,
            1.dp(),
            matchParent,
            startToStart = this.id,
            endToEnd = this.id,
            bottomToBottom = this.id,
            parentView = this
        )


    }


    fun getNewGuideline(context: Context, orientation: Int): Guideline {
        val guideline = Guideline(context)
        guideline.id = Guideline.generateViewId()
        val lp = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        lp.orientation = orientation
        guideline.layoutParams = lp
        return guideline
    }


    fun setConstraintWidth(isConstraintWidth: Boolean, view: View) {
        val constraintLayoutParams = view.layoutParams as (LayoutParams)
        constraintLayoutParams.constrainedWidth = isConstraintWidth
        view.layoutParams = constraintLayoutParams
    }


}