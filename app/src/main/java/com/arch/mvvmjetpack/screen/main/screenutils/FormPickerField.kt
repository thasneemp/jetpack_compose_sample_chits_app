package com.arch.mvvmjetpack.screen.main.screenutils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.arch.mvvmjetpack.R

class FormPickerField(
    override val name: String,
    label: String = "",
    override val validators: List<Validator>,
    val specimens: Map<String,String>,
) : BaseField(name, label, validators) {

    @Composable
    override fun Content() {
        var expanded by remember { mutableStateOf(false) }
        Box(modifier = Modifier.padding(10.dp)) {
            OutlinedTextField(
                value = text,
                isError = hasError,
                onValueChange = { value ->
                    text = value
                },
                textStyle = TextStyle(color = colorResource(id = R.color.semi_green)),
                label = { Text(lbl) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(
                        id = R.color.semi_green,
                    ),
                    unfocusedBorderColor = colorResource(id = R.color.semi_green),
                    focusedLabelColor = colorResource(id = R.color.semi_green),
                ),
                trailingIcon = { Icon(Icons.Outlined.ArrowDropDown, null) },
                readOnly = true,
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                Modifier.fillMaxWidth()
            ) {
                specimens.forEach { specimen ->
                    DropdownMenuItem(onClick = {
                        hideError()
                        expanded = false
                        text = specimen.value
                    }) {
                        Text(
                            text = specimen.value,
                            style = TextStyle(color = colorResource(id = R.color.semi_green))
                        )
                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Transparent)
                    .padding(5.dp)
                    .clickable(
                        onClick = { expanded = !expanded }
                    )
            )
        }

    }


}