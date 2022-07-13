package com.arch.mvvmjetpack.screen.main.screenutils

import android.util.Patterns
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

abstract class BaseField(
    open val name: String,
    val labelString: String = "", open val validators: List<Validator>
) {

    @Composable
    abstract fun Content()
    var lbl: String by mutableStateOf(labelString)


    var text: String by mutableStateOf("")

    var hasError: Boolean by mutableStateOf(false)

    fun clear() {
        text = ""
    }


    fun showError(error: String) {
        hasError = true
        lbl = error
    }

    fun hideError() {
        lbl = labelString
        hasError = false
    }

    fun validate(): Boolean {
        return validators.map {
            when (it) {
                is Email -> {
                    if (!Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
                        showError(it.message)
                        return@map false
                    }
                    true
                }
                is Required -> {
                    if (text.isEmpty()) {
                        showError(it.message)
                        return@map false
                    }
                    true
                }
                is Regex -> {
                    if (!it.regex.toRegex().containsMatchIn(text)) {
                        showError(it.message)
                        return@map false
                    }
                    true
                }
            }
        }.all { it }
    }
}