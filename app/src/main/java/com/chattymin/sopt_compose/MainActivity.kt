package com.chattymin.sopt_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chattymin.sopt_compose.navigation.BottomNavItem
import com.chattymin.sopt_compose.navigation.BottomNavigation
import com.chattymin.sopt_compose.navigation.MainNavigation
import com.chattymin.sopt_compose.ui.theme.SoptcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoptcomposeTheme {
                val navController = rememberNavController()
                val screens = listOf(
                    BottomNavItem.Android.route,
                    BottomNavItem.Home.route,
                    BottomNavItem.My.route,
                )
                val showBottomNav = navController
                    .currentBackStackEntryAsState().value?.destination?.route in screens.map { it }

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding(),
                    bottomBar = {
                        AnimatedVisibility(
                            visible = showBottomNav,
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            BottomNavigation(navController = navController)
                        }
                    }
                ) {
                    MainNavigation(navController = navController, modifier = Modifier.padding(it))
                }
            }
        }
    }
}
