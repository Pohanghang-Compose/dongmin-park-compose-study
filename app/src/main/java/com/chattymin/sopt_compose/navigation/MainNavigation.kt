package com.chattymin.sopt_compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.chattymin.sopt_compose.feature.auth.signin.SignInPage
import com.chattymin.sopt_compose.feature.auth.signup.SignUpPage
import com.chattymin.sopt_compose.feature.main.android.AndroidPage
import com.chattymin.sopt_compose.feature.main.home.HomePage
import com.chattymin.sopt_compose.feature.main.my.MyPage

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController, startDestination = Graph.Auth.route) {
        authGraph(navController)
        mainGraph(navController, modifier)
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

fun NavGraphBuilder.mainGraph(navController: NavController, modifier: Modifier) {
    navigation(startDestination = BottomNavItem.Home.route, route = Graph.Main.route) {
        composable(
            BottomNavItem.Android.route
        ) {
            AndroidPage(navController = navController, modifier)
        }
        composable(
            route = BottomNavItem.Home.route
        ) {
            HomePage(navController = navController, modifier)
        }
        composable(
            route = BottomNavItem.My.route
        ) {
            MyPage(navController = navController, modifier)
        }
    }
}
