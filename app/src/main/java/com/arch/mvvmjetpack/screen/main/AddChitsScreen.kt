package com.arch.mvvmjetpack.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.arch.mvvmjetpack.R


@Composable
fun AddChitsScreen(navController: NavHostController, viewModel: AddChitsViewModel) {
    val textOutLineStyle = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = colorResource(
            id = R.color.semi_green,
        ),
        unfocusedBorderColor = colorResource(id = R.color.semi_green),
        focusedLabelColor = colorResource(id = R.color.semi_green),
    )
    var title by remember { mutableStateOf("") }
    var currency by remember { mutableStateOf("") }
    var drawAmount by remember { mutableStateOf("") }
    var installment by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }
    var drawDate by remember { mutableStateOf("") }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Add Chits")
            },
            backgroundColor = Color.White,
            contentColor = Color.Black,
            elevation = 12.dp,
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "", tint = Color.Black)
                }
            },
            actions = {}
        )
    }) {

        Box(modifier = Modifier.fillMaxWidth()) {
            val items = ArrayList<String>()
            items.add("د.إ")
            items.add("₹")
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                item {
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Title") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        maxLines = 2,
                        textStyle = TextStyle(
                            color = colorResource(id = R.color.semi_green),
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(), colors = textOutLineStyle
                    )
                }
                item {
                    SpecimenSpinners(textOutLineStyle, specimens = items) {
                        currency = it
                    }
                }
                item {
                    OutlinedTextField(
                        value = drawAmount,
                        onValueChange = { drawAmount = it },
                        label = { Text("Draw amount") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        maxLines = 2,
                        textStyle = TextStyle(
                            color = colorResource(id = R.color.semi_green),
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(), colors = textOutLineStyle
                    )

                }
                item {
                    OutlinedTextField(
                        value = installment,
                        onValueChange = { installment = it },
                        label = { Text("Installment") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        maxLines = 2,
                        textStyle = TextStyle(
                            color = colorResource(id = R.color.semi_green),
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(), colors = textOutLineStyle
                    )

                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = startDate,
                            onValueChange = { startDate = it },
                            readOnly = true,
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.DateRange,
                                    contentDescription = "start date"
                                )
                            },
                            label = { Text("Start Date") },
                            maxLines = 1,
                            textStyle = TextStyle(
                                color = colorResource(id = R.color.semi_green),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier
                                .padding(10.dp)
                                .weight(1f), colors = textOutLineStyle
                        )

                        OutlinedTextField(
                            value = endDate,
                            onValueChange = { endDate = it },
                            readOnly = true,
                            label = { Text("End Date") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.DateRange,
                                    contentDescription = "end date"
                                )
                            },
                            maxLines = 1,
                            textStyle = TextStyle(
                                color = colorResource(id = R.color.semi_green),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .weight(1f), colors = textOutLineStyle
                        )

                    }
                }

                item {
                    OutlinedTextField(
                        value = drawDate,
                        onValueChange = { drawDate = it },
                        readOnly = true,
                        label = { Text("Draw Date") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "end date"
                            )
                        },
                        maxLines = 2,
                        textStyle = TextStyle(
                            color = colorResource(id = R.color.semi_green),
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp), colors = textOutLineStyle
                    )


                }

                item {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.semi_green),
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .width(250.dp)
                        ) {
                            Text(text = "Submit")
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun SpecimenSpinners(
    textOutLineStyle: TextFieldColors,
    specimens: List<String>,
    textChange: (String) -> Unit
) {

    var specimenText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }


    Box(modifier = Modifier.padding(10.dp)) {
        OutlinedTextField(
            value = (specimenText),
            onValueChange = textChange,
            textStyle = TextStyle(color = colorResource(id = R.color.semi_green)),
            label = {
                Text(
                    text = "Select Currency",
                    style = TextStyle(
                    )
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = textOutLineStyle,
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
                    expanded = false
                    specimenText = specimen
                }) {
                    Text(
                        text = specimen,
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