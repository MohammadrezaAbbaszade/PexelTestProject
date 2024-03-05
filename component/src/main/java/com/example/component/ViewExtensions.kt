package com.example.component

import android.content.res.Resources
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import kotlin.math.ceil


val View.wrapContent: Int
    get() = -2

val Fragment.wrapContent: Int
    get() = -2

val Fragment.matchParent: Int
    get() = -1

val View.matchParent: Int
    get() = -1

fun View.addViewToConstraintLayout(
    parentView: ConstraintLayout,
    childView: View
) {
    parentView.addView(childView)
}

fun Fragment.addViewToConstraintLayout(
    parentView: ConstraintLayout,
    childView: View
) {
    parentView.addView(childView)
}

fun Fragment.addConstraintSet(
    childViewId: Int,
    height: Int,
    width: Int,
    topToTop: Int? = null,
    topToBottom: Int? = null,
    bottomToTop: Int? = null,
    bottomToBottom: Int? = null,
    startToStart: Int? = null,
    startToEnd: Int? = null,
    endToEnd: Int? = null,
    endToStart: Int? = null,
    marginTop: Int = 0,
    marginBottom: Int = 0,
    marginStart: Int = 0,
    marginEnd: Int = 0,
    goneMarginLeft: Int = Int.MIN_VALUE,
    goneMarginTop: Int = Int.MIN_VALUE,
    parentView: ConstraintLayout,
    horizontalWeight: Float = 1f,
    defaultWidth: Int = ConstraintSet.MATCH_CONSTRAINT_SPREAD,
    verticalChainStyle: Int = ConstraintSet.CHAIN_PACKED,
    horizontalChainStyle: Int = ConstraintSet.CHAIN_PACKED,
    horizontalBias: Float = 0.5f,
    verticalBias: Float = 0.5f
) {
    val set = ConstraintSet()
    set.constrainHeight(childViewId, height)
    set.constrainWidth(childViewId, width)
    set.setHorizontalBias(childViewId, horizontalBias)
    set.setVerticalBias(childViewId, verticalBias)
    set.constrainDefaultWidth(childViewId, defaultWidth)
    set.setGoneMargin(childViewId, ConstraintSet.START, goneMarginLeft)
    set.setGoneMargin(childViewId, ConstraintSet.TOP, goneMarginTop)
    topToTop?.let {
        set.connect(
            childViewId,
            ConstraintSet.TOP,
            topToTop,
            ConstraintSet.TOP,
            marginTop
        )
    }
    if (topToBottom != null) {
        set.connect(childViewId, ConstraintSet.TOP, topToBottom, ConstraintSet.BOTTOM, marginTop)
    }
    if (bottomToTop != null) {
        set.connect(childViewId, ConstraintSet.BOTTOM, bottomToTop, ConstraintSet.TOP, marginBottom)
    }
    if (bottomToBottom != null) {
        set.connect(
            childViewId,
            ConstraintSet.BOTTOM,
            bottomToBottom,
            ConstraintSet.BOTTOM,
            marginBottom
        )
    }
    if (startToStart != null) {
        set.connect(
            childViewId,
            ConstraintSet.START,
            startToStart,
            ConstraintSet.START,
            marginStart
        )
    }
    if (startToEnd != null) {
        set.connect(childViewId, ConstraintSet.START, startToEnd, ConstraintSet.END, marginStart)
    }
    if (endToEnd != null) {
        set.connect(childViewId, ConstraintSet.END, endToEnd, ConstraintSet.END, marginEnd)
    }
    if (endToStart != null) {
        set.connect(childViewId, ConstraintSet.END, endToStart, ConstraintSet.START, marginEnd)
    }

    set.applyTo(parentView)


}

fun View.addConstraintSet(
    childViewId: Int,
    height: Int,
    width: Int,
    topToTop: Int? = null,
    topToBottom: Int? = null,
    bottomToTop: Int? = null,
    bottomToBottom: Int? = null,
    startToStart: Int? = null,
    startToEnd: Int? = null,
    endToEnd: Int? = null,
    endToStart: Int? = null,
    marginTop: Int = 0,
    marginBottom: Int = 0,
    marginStart: Int = 0,
    marginEnd: Int = 0,
    goneMarginLeft: Int = Int.MIN_VALUE,
    goneMarginTop: Int = Int.MIN_VALUE,
    parentView: ConstraintLayout,
    horizontalWeight: Float = 1f,
    defaultWidth: Int = ConstraintSet.MATCH_CONSTRAINT_SPREAD,
    verticalChainStyle: Int = ConstraintSet.CHAIN_PACKED,
    horizontalChainStyle: Int = ConstraintSet.CHAIN_PACKED,
    horizontalBias: Float = 0.5f,
    verticalBias: Float = 0.5f
) {
    val set = ConstraintSet()
    set.constrainHeight(childViewId, height)
    set.constrainWidth(childViewId, width)
    set.setHorizontalBias(childViewId, horizontalBias)
    set.setVerticalBias(childViewId, verticalBias)
    set.constrainDefaultWidth(childViewId, defaultWidth)
    set.setGoneMargin(childViewId, ConstraintSet.START, goneMarginLeft)
    set.setGoneMargin(childViewId, ConstraintSet.TOP, goneMarginTop)
    topToTop?.let {
        set.connect(
            childViewId,
            ConstraintSet.TOP,
            topToTop,
            ConstraintSet.TOP,
            marginTop
        )
    }
    if (topToBottom != null) {
        set.connect(childViewId, ConstraintSet.TOP, topToBottom, ConstraintSet.BOTTOM, marginTop)
    }
    if (bottomToTop != null) {
        set.connect(childViewId, ConstraintSet.BOTTOM, bottomToTop, ConstraintSet.TOP, marginBottom)
    }
    if (bottomToBottom != null) {
        set.connect(
            childViewId,
            ConstraintSet.BOTTOM,
            bottomToBottom,
            ConstraintSet.BOTTOM,
            marginBottom
        )
    }
    if (startToStart != null) {
        set.connect(
            childViewId,
            ConstraintSet.START,
            startToStart,
            ConstraintSet.START,
            marginStart
        )
    }
    if (startToEnd != null) {
        set.connect(childViewId, ConstraintSet.START, startToEnd, ConstraintSet.END, marginStart)
    }
    if (endToEnd != null) {
        set.connect(childViewId, ConstraintSet.END, endToEnd, ConstraintSet.END, marginEnd)
    }
    if (endToStart != null) {
        set.connect(childViewId, ConstraintSet.END, endToStart, ConstraintSet.START, marginEnd)
    }

    set.applyTo(parentView)


}

fun Int.dp() : Int{
    return if (this == 0) {
        0
    } else ceil((Resources.getSystem().displayMetrics.density * this).toDouble()).toInt()
}

fun Int.dpToPx(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

fun Int.pxToDp(): Int {
    return (this / Resources.getSystem().displayMetrics.density).toInt()
}