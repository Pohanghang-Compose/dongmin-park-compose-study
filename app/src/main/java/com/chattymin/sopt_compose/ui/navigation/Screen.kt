package com.chattymin.sopt_compose.ui.navigation

sealed class Screen(val route: String) {
    object SignIn : Screen(route = "login")
    object SignUp : Screen(route = "signup")
    object Main : Screen(route = "main")
}
