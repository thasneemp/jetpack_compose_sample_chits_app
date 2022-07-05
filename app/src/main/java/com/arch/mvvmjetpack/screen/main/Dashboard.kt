package com.arch.mvvmjetpack.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Paid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.arch.mvvmjetpack.R
import com.arch.mvvmjetpack.screen.ScreenRoute

@Composable
fun ChitDashboard(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Chits")
            },
            backgroundColor = Color.White,
            contentColor = Color.Black,
            elevation = 12.dp,
            actions = {
//                IconButton(onClick = {
//                }) {
//                    Icon(Icons.Default.Refresh, contentDescription = "", tint = Color.Black)
//                }

            }
        )
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate("${ScreenRoute.AddChit.route}/")
        }, backgroundColor = colorResource(id = R.color.semi_green)) {
            Icon(Icons.Filled.Add, contentDescription = "add", tint = Color.White)
        }
    }, floatingActionButtonPosition = FabPosition.End) {
        Box(modifier = Modifier.background(Color.White)) {
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
            LazyColumn {
                items(list) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .clickable {
                                navController.navigate("${ScreenRoute.ChitDetailsScreen.route}/")
                            },
                        elevation = 5.dp,
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                start = 10.dp,
                                end = 10.dp,
                                top = 5.dp,
                                bottom = 5.dp
                            )
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(text = "Muhammed")
                                    Icon(
                                        Icons.Filled.Paid,
                                        contentDescription = "search",
                                        tint = colorResource(id = R.color.gold),
                                        modifier = Modifier
                                            .height(20.dp)
                                            .width(20.dp)
                                    )
                                }
                                Column {
                                    Text(text = "Muhammed")
                                    Text(text = "Muhammed")
                                    Text(
                                        text = "Muhammed",
                                        style = TextStyle(Color.Gray, fontStyle = FontStyle.Italic)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            LinearProgressIndicator(
                                color = colorResource(id = R.color.semi_green),
                                progress = 0.1f,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(3.dp))
                                    .height(15.dp)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Muhammed",
                                    style = TextStyle(Color.Gray, fontStyle = FontStyle.Italic)
                                )
                                Text(
                                    text = "Muhammed",
                                    style = TextStyle(Color.Gray, fontStyle = FontStyle.Italic)
                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "Your last payment was done 12-June-2022",
                                style = TextStyle(Color.Gray, fontStyle = FontStyle.Italic)
                            )
                        }
                    }
                }
            }
        }
    }
}