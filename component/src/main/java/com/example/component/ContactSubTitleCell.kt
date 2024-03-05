package com.example.component

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.res.ResourcesCompat



abstract class ContactSubTitleCell(
    context: Context,
) : BaseContactCell(context) {
    val set = ConstraintSet()
    lateinit var middleSubTitle: TextView
    lateinit var lastSubTitle: TextView

    init {
        middleSubTitle = TextView(context).apply {
            this.id = View.generateViewId()
            setTextColor(Color.parseColor("#18181B"))
            textSize = 12f
            isSingleLine = true
            gravity = Gravity.RIGHT
            setTypeface(this.typeface, Typeface.BOLD)
            ellipsize = TextUtils.TruncateAt.END
        }

        lastSubTitle = TextView(context).apply {
            this.id = View.generateViewId()
            setTextColor(Color.parseColor("#787A87")  )
            textSize = 12f
            isSingleLine = true
            gravity = Gravity.RIGHT
            ellipsize = TextUtils.TruncateAt.END
        }

        addViewToConstraintLayout(this, middleSubTitle)
        addViewToConstraintLayout(this, lastSubTitle)


        set.clone(this)
        set.createVerticalChain(
            ConstraintSet.PARENT_ID,
            ConstraintSet.TOP,
            ConstraintSet.PARENT_ID,
            ConstraintSet.BOTTOM,
            intArrayOf(roomTitleWithIcons.id, middleSubTitle.id, lastSubTitle.id),
            null,
            ConstraintSet.CHAIN_PACKED
        )
        set.applyTo(this)

        addConstraintSet(
            roomTitleWithIcons.id,
            wrapContent,
            wrapContent,
            bottomToTop = middleSubTitle.id,
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
            middleSubTitle.id,
            wrapContent,
            0,
            bottomToTop = lastSubTitle.id,
            endToEnd = roomTitleWithIcons.id,
            startToEnd = verticalGuideLine.id,
            topToBottom = roomTitleWithIcons.id,
            horizontalBias = 1f,
            marginTop = 4.dp(),
            parentView = this
        )


        addConstraintSet(
            lastSubTitle.id,
            20.dp(),
            0,
            bottomToBottom = avatarImageView.id,
            endToEnd = middleSubTitle.id,
            startToStart = this.id,
            topToBottom = middleSubTitle.id,
            horizontalBias = 1f,
            marginStart = 8.dp(),
            goneMarginTop = 4.dp(),
            parentView = this
        )

    }


}