package com.arch.mvvmjetpack.screen.main.dates

import java.text.SimpleDateFormat
import java.util.*

const val DEFAULT_DATE_FORMAT = "MM-dd-yyyy"
const val DEFAULT_TIME_FORMAT = "hh:mm a"
const val DEFAULT_FORMAT_TIME_DATE = "MM-dd-yyyy hh:mm a"
fun String.toDate(format: String?, locale: Locale? = Locale.ENGLISH): Date? =
    format?.let {
        if (this.isNotEmpty()) SimpleDateFormat(
            format,
            locale
        ).parse(this) else null
    }
