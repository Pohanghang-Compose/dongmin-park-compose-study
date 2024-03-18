package com.chattymin.sopt_compose.navigation

sealed class Screen(val route: String) {
    // Auth
    data object SignIn : Screen(route = "login")
    data object SignUp : Screen(route = "signup")

    // Main
    data object Android : Screen(route = "android")
    data object Home : Screen(route = "home")
    data object My : Screen(route = "my")
}
