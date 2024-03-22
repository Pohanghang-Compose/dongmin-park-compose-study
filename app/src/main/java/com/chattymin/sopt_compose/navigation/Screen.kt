package com.chattymin.sopt_compose.navigation

sealed class Screen(val route: String) {
    data object SignIn : Screen(route = "login")
    data object SignUp : Screen(route = "signup")
}
