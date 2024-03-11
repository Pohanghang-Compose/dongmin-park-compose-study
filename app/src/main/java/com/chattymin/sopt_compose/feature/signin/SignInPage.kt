package com.chattymin.sopt_compose.feature.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chattymin.sopt_compose.ui.theme.SoptcomposeTheme

@Composable
fun SignInPage(navController: NavController) {
    Scaffold(
        topBar = {
            Text(text = "Welcome to SOPT")
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Sign In")
        }
    }
}

@Preview
@Composable
fun SignInPreview() {
    SoptcomposeTheme {
        SignInPage(navController = rememberNavController())
    }
}
