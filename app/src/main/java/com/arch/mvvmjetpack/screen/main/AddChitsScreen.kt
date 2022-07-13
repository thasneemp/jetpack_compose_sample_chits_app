package com.arch.mvvmjetpack.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.arch.mvvmjetpack.R
import com.arch.mvvmjetpack.database.ChitsMasterEntity
import com.arch.mvvmjetpack.screen.main.screenutils.*


@Composable
fun AddChitsScreen(navController: NavHostController, viewModel: AddChitsViewModel) {
    val collectAsState by viewModel.mState.collectAsState()
//    when (collectAsState) {
//        is AddChitState.IsLoading -> {
//
//        }
//        is AddChitState.Data -> {
//
//        }
//        is AddChitState.Init -> {}
//        is AddChitState.ShowToast -> {}
//    }
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

        val state by remember { mutableStateOf(FormState()) }

        Box(modifier = Modifier.fillMaxWidth()) {
            val items = mapOf(Pair("د.إ", "UAE"), Pair("₹", "India"))
            Column {
                Form(
                    state = state, formFields = listOf(
                        FormTextField(
                            label = "Title",
                            name = "title",
                            validators = listOf(Required("Title cannot be empty")),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            )
                        ),

                        FormPickerField(
                            label = "Currency",
                            name = "currency",
                            validators = listOf(Required("currency cannot be empty")),
                            specimens = items
                        ),
                        FormTextField(
                            label = "Draw amount",
                            name = "drawAmount",
                            validators = listOf(Required("Draw cannot be empty")),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        ),
                        FormTextField(
                            label = "Installment",
                            name = "installment",
                            validators = listOf(Required("Installment cannot be empty")),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        ),
                        FormDateField(
                            label = "Start Date",
                            name = "startDate",
                            validators = listOf(Required("Start cannot be empty")),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            readOnly = true,
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.DateRange,
                                    contentDescription = "start date"
                                )
                            }
                        ),
                        FormDateField(
                            label = "End Date",
                            name = "endDate",
                            onClick = {},
                            validators = listOf(Required("End Date cannot be empty")),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            readOnly = true,
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.DateRange,
                                    contentDescription = "send date"
                                )
                            }
                        ),
                        FormDateField(
                            label = "Draw Date",
                            name = "drawDate",
                            onClick = {},
                            validators = listOf(Required("Draw Date cannot be empty")),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            readOnly = true,
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.DateRange,
                                    contentDescription = "draw date"
                                )
                            }
                        ),

                        )
                )

                Box(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = {
                            if (state.validate()) {
                                val entity = ChitsMasterEntity(
                                    title = state.getData()["title"],
                                    currencyId = state.getData()["currency"],
                                    drawAmount = state.getData()["drawAmount"],
                                    instalment = state.getData()["installment"],
                                    startDate = state.getData()["startDate"],
                                    endDate = state.getData()["endDate"],
                                    drawDate = state.getData()["drawDate"],
                                    lastPaymentDate = "",
                                    id = 0
                                )
                                viewModel.addChits(entity)
                            }
                        },
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




