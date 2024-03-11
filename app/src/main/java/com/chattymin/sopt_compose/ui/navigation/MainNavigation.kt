package com.chattymin.sopt_compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chattymin.sopt_compose.ui.feature.main.MainPage
import com.chattymin.sopt_compose.ui.feature.signin.SignInPage
import com.chattymin.sopt_compose.ui.feature.signup.SignUpPage

@Composable
fun MainNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.SignIn.route) {
        composable(
            route = Screen.SignIn.route
        ) {
            SignInPage(navController)
        }

        composable(
            route = Screen.SignUp.route
        ) {
            SignUpPage(navController = navController)
        }

        composable(
            route = Screen.Main.route
        ) {
            MainPage(navController = navController)
        }
    }
}
