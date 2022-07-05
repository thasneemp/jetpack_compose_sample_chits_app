package com.arch.mvvmjetpack.screen

sealed class ScreenRoute(
    val route: String
) {
    object ChitDashboard : ScreenRoute("chitdashboard")
    object AddChit : ScreenRoute("addchit")
    object ChitDetailsScreen : ScreenRoute("chitdetailsscreen")
}