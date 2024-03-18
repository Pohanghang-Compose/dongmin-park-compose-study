package com.chattymin.sopt_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.chattymin.sopt_compose.feature.main.my.MainPage
import com.chattymin.sopt_compose.feature.auth.signin.SignInPage
import com.chattymin.sopt_compose.feature.auth.signup.SignUpPage

@Composable
fun MainNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Graph.Auth.route) {
        authGraph(navController)
        mainGraph(navController)
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

fun NavGraphBuilder.mainGraph(navController: NavController) {
    navigation(startDestination = Screen.Home.route, route = Graph.Main.route) {
        composable(
            route = Screen.Home.route
        ) {
            MainPage(navController = navController)
        }
    }
}
