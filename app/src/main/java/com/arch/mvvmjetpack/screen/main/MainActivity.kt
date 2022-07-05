package com.arch.mvvmjetpack.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arch.mvvmjetpack.screen.ScreenRoute
import com.arch.mvvmjetpack.ui.theme.MVVMJetPackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            MYApp(this)

        }
    }

}

@Composable
private fun MYApp(mainActivity: MainActivity) {
    MVVMJetPackTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = ScreenRoute.ChitDashboard.route) {
            composable(ScreenRoute.ChitDashboard.route) {
                ChitDashboard(navController)
            }
            composable("${ScreenRoute.AddChit.route}/") {
                val viewModel = hiltViewModel<AddChitsViewModel>()
                AddChitsScreen(navController, viewModel)
            }

            composable("${ScreenRoute.ChitDetailsScreen.route}/") {
                val viewModel = hiltViewModel<ChitsDetailsViewModel>()
                ChitDetailsScreen(navController, viewModel)
            }
//            composable(
//                "${ScreenRoute.ChitDashboard.route}/{data}",
//                arguments = listOf(navArgument("data") {
//                    type =
//                        NavType.StringType
//                })
//            ) { backStackEntry ->
////                val result =
////                    URLDecoder.decode((backStackEntry.arguments?.getString("data") ?: ""), "utf-8")
////                        .fromJson(Result::class.java)
//
//            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVMJetPackTheme {
//        Greeting("Android")
    }
}