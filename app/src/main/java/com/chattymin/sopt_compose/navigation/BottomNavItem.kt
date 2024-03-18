package com.chattymin.sopt_compose.navigation

import com.chattymin.sopt_compose.R

sealed class BottomNavItem(
    val title: String, val icon: Int, val route: String
) {
    data object Android: BottomNavItem("Android", R.drawable.img_profile, "android")
    data object Home: BottomNavItem("Home", R.drawable.ic_launcher_foreground, "home")
    data object My: BottomNavItem("My", androidx.core.R.drawable.ic_call_answer, "my")
}
