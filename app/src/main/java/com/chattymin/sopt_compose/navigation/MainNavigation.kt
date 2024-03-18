package com.chattymin.sopt_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.chattymin.sopt_compose.feature.main.MainPage
import com.chattymin.sopt_compose.feature.signin.SignInPage
import com.chattymin.sopt_compose.feature.signup.SignUpPage

@Composable
fun MainNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Graph.Auth.route) {
        authGraph(navController)

        composable(
            route = Screen.Main.route
        ) {
            MainPage(navController = navController)
        }
    }
}

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(startDestination = Screen.SignIn.route, route = Graph.Auth.route) {
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
    }
}
