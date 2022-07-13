package com.arch.mvvmjetpack.screen.main.screenutils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.arch.mvvmjetpack.R

class FormTextField(
    override val name: String,
    label: String = "",
    override val validators: List<Validator>,
    val readOnly: Boolean = false,
    val leadingIcon: @Composable (() -> Unit)? = null,
    val trailingIcon: @Composable (() -> Unit)? = null,
    val onClick: (() -> Unit)? = null,
    val keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) : BaseField(name, label, validators) {


    @Composable
    override fun Content() {
        OutlinedTextField(
            value = text,
            isError = hasError,
            readOnly = readOnly,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            onValueChange = { value ->
                hideError()
                text = value
                validate()
            },
            enabled = onClick == null,
            label = { Text(lbl) },
            keyboardOptions = keyboardOptions,
            maxLines = 2,
            textStyle = TextStyle(
                color = colorResource(id = R.color.semi_green),
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .clickable {
                    onClick?.invoke()
                }, colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(
                    id = R.color.semi_green,
                ),
                unfocusedBorderColor = colorResource(id = R.color.semi_green),
                focusedLabelColor = colorResource(id = R.color.semi_green),
                disabledBorderColor = if (!hasError) colorResource(id = R.color.semi_green) else colorResource(
                    id = R.color.red
                )
            )
        )
    }


}