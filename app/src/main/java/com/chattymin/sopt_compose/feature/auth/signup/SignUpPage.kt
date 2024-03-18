package com.chattymin.sopt_compose.feature.auth.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chattymin.sopt_compose.R
import com.chattymin.sopt_compose.components.spacer.Spacer
import com.chattymin.sopt_compose.components.text.TitleText
import com.chattymin.sopt_compose.ext.addFocusCleaner
import com.chattymin.sopt_compose.ext.toast
import com.chattymin.sopt_compose.feature.auth.signin.TitleWithEditTextView
import com.chattymin.sopt_compose.navigation.Screen
import com.chattymin.sopt_compose.ui.theme.SoptcomposeTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SignUpPage(navController: NavController) {
    val viewModel: SignUpViewModel = viewModel()
    val context = LocalContext.current

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
                .addFocusCleaner(LocalFocusManager.current),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TitleWithEditTextView(
                title = stringResource(id = R.string.id),
                value = state.id,
                hint = stringResource(id = R.string.auth_id_hint)
            ) {
                viewModel.valueChanged(id = it)
            }

            Spacer(dp = 20)

            TitleWithEditTextView(
                title = stringResource(id = R.string.pw),
                value = state.pw,
                hint = stringResource(id = R.string.auth_pw_hint)
            ) {
                viewModel.valueChanged(pw = it)
            }

            Spacer(dp = 20)

            TitleWithEditTextView(
                title = stringResource(id = R.string.nicknmae),
                value = state.nickname,
                hint = stringResource(id = R.string.auth_nickname_hint)
            ) {
                viewModel.valueChanged(nickname = it)
            }

            Spacer(dp = 20)

            TitleWithEditTextView(
                title = stringResource(id = R.string.single_info),
                value = state.singleInfo,
                hint = stringResource(id = R.string.auth_single_info_hint)
            ) {
                viewModel.valueChanged(singleInfo = it)
            }

            Spacer(dp = 20)

            TitleWithEditTextView(
                title = stringResource(id = R.string.specialty),
                value = state.specialty,
                hint = stringResource(id = R.string.auth_specialty_hint)
            ) {
                viewModel.valueChanged(specialty = it)
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                Button(
                    enabled = state.canSignUp,
                    onClick = {
                        viewModel.signUpBtnClicked()
                    }) {
                    Text(text = stringResource(id = R.string.sign_up_btn))
                }
            }
        }
    }

    viewModel.collectSideEffect {
        when (it) {
            SignUpSideEffect.NavigateToSignUp -> {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "id",
                    value = state.id
                )
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "pw",
                    value = state.pw
                )
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "nickname",
                    value = state.nickname
                )
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "singleInfo",
                    value = state.singleInfo
                )
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "specialty",
                    value = state.specialty
                )
                navController.navigate(Screen.SignIn.route)
            }

            is SignUpSideEffect.Toast -> toast(context, context.getString(R.string.sign_up_success))
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