package com.chattymin.sopt_compose.feature.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chattymin.sopt_compose.R
import com.chattymin.sopt_compose.components.spacer.VerticalSpacer
import com.chattymin.sopt_compose.components.text.TitleText
import com.chattymin.sopt_compose.ext.addFocusCleaner
import com.chattymin.sopt_compose.feature.signin.TitleWithEtv
import com.chattymin.sopt_compose.navigation.Screen
import com.chattymin.sopt_compose.ui.theme.SoptcomposeTheme
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun SignUpPage(navController: NavController) {
    val viewModel: SignUpViewModel = viewModel()
    val focusManager = LocalFocusManager.current

    val state by viewModel.collectAsState()

    Scaffold(
        topBar = {
            TitleText(text = stringResource(id = R.string.sign_up_title))
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
                .addFocusCleaner(focusManager),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TitleWithEtv(
                title = stringResource(id = R.string.id),
                value = state.id,
                hint = stringResource(id = R.string.auth_id_hint)
            ){
                viewModel.idChanged(it)
            }

            VerticalSpacer(dp = 20)

            TitleWithEtv(
                title = stringResource(id = R.string.pw),
                value = state.pw,
                hint = stringResource(id = R.string.auth_pw_hint)
            ){
                viewModel.pwChanged(it)
            }

            VerticalSpacer(dp = 20)

            TitleWithEtv(
                title = stringResource(id = R.string.nicknmae),
                value = state.nickname,
                hint = stringResource(id = R.string.auth_nickname_hint)
            ){
                viewModel.nicknameChanged(it)
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                Button(
                    enabled = state.canSignUp,
                    onClick = {
                        navController.currentBackStackEntry?.savedStateHandle?.set(key = "id", value = state.id)
                        navController.currentBackStackEntry?.savedStateHandle?.set(key = "pw", value = state.pw)
                        navController.navigate(Screen.SignIn.route)
                }) {
                    Text(text = stringResource(id = R.string.sign_up_btn))
                }
            }
        }
    }
}


@Composable
@Preview
fun SignUpPreview() {
    SoptcomposeTheme {
        SignUpPage(navController = rememberNavController())
    }
}