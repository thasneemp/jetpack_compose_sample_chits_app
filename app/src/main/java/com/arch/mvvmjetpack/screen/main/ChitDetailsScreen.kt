package com.arch.mvvmjetpack.screen.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.arch.mvvmjetpack.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChitDetailsScreen(navController: NavHostController, viewModel: ChitsDetailsViewModel) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Chits Details")
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
            actions = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_price_won),
                        contentDescription = "",
                        modifier = Modifier
                            .height(25.dp)
                            .width(25.dp),

                        tint = colorResource(id = R.color.gold_dark)
                    )
                }

            }
        )

    }) {
        Box(modifier = Modifier.fillMaxWidth()) {
            val current = LocalContext.current
            LazyVerticalGrid(cells = GridCells.Fixed(5)) {
                val list = ArrayList<String>()
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                list.add("")
                itemsIndexed(list) { index, item ->
                    Card(
                        modifier = Modifier
                            .height(80.dp)
                            .padding(3.dp)
                            .combinedClickable(onLongClick = {

                            }) {},
                        elevation = 5.dp,
                        border = BorderStroke(
                            1.dp, color = colorResource(
                                id = R.color.semi_green
                            )

                        ),
                        backgroundColor = if (index % 2 == 0) colorResource(id = R.color.semi_green) else Color.White
                    ) {
                        Column(
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            if (index % 2 == 0) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_done_ico),
                                    contentDescription = "",
                                    tint = colorResource(id = R.color.white),
                                    modifier = Modifier
                                        .height(16.dp)
                                        .width(16.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "Jul",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (index % 2 == 0) Color.White else colorResource(id = R.color.semi_green)
                                )
                            )
                            Text(
                                text = "2022",
                                color = if (index % 2 == 0) Color.White else colorResource(id = R.color.semi_green)
                            )
                        }
                    }
                }
            }
        }
    }
}