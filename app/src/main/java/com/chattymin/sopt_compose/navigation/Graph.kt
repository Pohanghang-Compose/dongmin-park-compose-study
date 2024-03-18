package com.chattymin.sopt_compose.navigation

sealed class Graph(val route: String) {
    data object Auth : Graph(route = "auth")
}
