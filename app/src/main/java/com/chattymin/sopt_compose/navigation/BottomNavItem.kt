package com.chattymin.sopt_compose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import com.chattymin.sopt_compose.R

sealed class BottomNavItem(
    val title: Int, val icon: ImageVector, val route: String
) {
    data object Android : BottomNavItem(R.string.android, Icons.Filled.ThumbUp, "android")
    data object Home : BottomNavItem(R.string.home, Icons.Filled.Home, "home")
    data object My : BottomNavItem(R.string.my, Icons.Filled.Person, "my")
}
