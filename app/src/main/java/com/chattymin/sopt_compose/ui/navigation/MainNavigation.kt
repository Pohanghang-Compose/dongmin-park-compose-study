package com.chattymin.sopt_compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(
            route = Screen.Login.route
        ) {

        }
        composable(
            route = Screen.SignUp.route
        ) {

        }
        composable(
            route = Screen.Main.route
        ) {

        }
    }
}
