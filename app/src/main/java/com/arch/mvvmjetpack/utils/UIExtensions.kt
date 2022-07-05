package com.arch.mvvmjetpack.utils

import androidx.compose.ui.graphics.Color
import com.google.gson.Gson

val String.color
    get() = Color(android.graphics.Color.parseColor(this))

fun <A> String.fromJson(type: Class<A>): A {
    return Gson().fromJson(this, type)
}

fun <A> A.toJson(): String? {
    return Gson().toJson(this)
}