package com.arch.mvvmjetpack.screen.main.screenutils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Form(state: FormState, formFields: List<BaseField>) {
    state.formFields = formFields
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(formFields) {
            it.Content()
        }
    }
}

class FormState {
    var formFields: List<BaseField> = listOf()

    fun validate(): Boolean {
        var valid = true
        for (field in formFields) if (!field.validate()) {
            valid = false
            continue
        }
        return valid
    }

    fun getData(): Map<String, String> = formFields.associate { it.name to it.text }
}