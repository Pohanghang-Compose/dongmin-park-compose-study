package com.chattymin.sopt_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.chattymin.sopt_compose.navigation.MainNavigation
import com.chattymin.sopt_compose.ui.theme.SoptcomposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoptcomposeTheme {
                val navController = rememberNavController()
                MainNavigation(navController = navController)
            }
        }
    }
}
