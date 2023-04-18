package com.test.core_base.ui

import android.content.res.Resources.getSystem

fun Int.dpToPx(): Int = (this * getSystem().displayMetrics.density).toInt()
fun Int.pxToDp(): Int = (this / getSystem().displayMetrics.density).toInt()
