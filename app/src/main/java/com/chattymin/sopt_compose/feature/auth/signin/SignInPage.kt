package com.chattymin.sopt_compose.feature.auth.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chattymin.sopt_compose.R
import com.chattymin.sopt_compose.components.spacer.Spacer
import com.chattymin.sopt_compose.components.text.TitleText
import com.chattymin.sopt_compose.components.textfield.EditTextField
import com.chattymin.sopt_compose.ext.addFocusCleaner
import com.chattymin.sopt_compose.ext.navigateClear
import com.chattymin.sopt_compose.ext.toast
import com.chattymin.sopt_compose.navigation.BottomNavItem
import com.chattymin.sopt_compose.navigation.Screen
import com.chattymin.sopt_compose.ui.theme.SoptcomposeTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SignInPage(
    navController: NavController
) {
    val viewModel: SignInViewModel = viewModel()

    val state by viewModel.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        navController.previousBackStackEntry?.savedStateHandle?.run {
            val id = get<String>("id") ?: ""
            val pw = get<String>("pw") ?: ""
            val nickname = get<String>("nickname") ?: ""
            val singleInfo = get<String>("singleInfo") ?: ""
            val specialty = get<String>("specialty") ?: ""

            viewModel.run {
                valueChanged(id, pw)
                this.nickname = nickname
                this.singleInfo = singleInfo
                this.specialty = specialty
            }
        }
    }

    viewModel.collectSideEffect {
        when (it) {
            SignInSideEffect.NavigateToMain -> navigateToMain(navController, state, viewModel)
            SignInSideEffect.NavigateToSignUp -> navController.navigate(Screen.SignUp.route)
            SignInSideEffect.Toast -> toast(context, context.getString(R.string.sign_in_success))
        }
    }

    Scaffold(
        topBar = {
            TitleText(text = stringResource(id = R.string.sign_in_title))
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
                hint = stringResource(id = R.string.auth_pw_hint),
                keyboardType = KeyboardType.Password
            ) {
                viewModel.valueChanged(pw = it)
            }

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    enabled = state.canSignIn,
                    onClick = {
                        viewModel.signInButtonClicked()
                    }
                ) {
                    Text(text = stringResource(id = R.string.sign_in_btn))
                }

                Spacer(dp = 4)

                Button(
                    onClick = { viewModel.navigateToSignUpPage() }
                ) {
                    Text(text = stringResource(id = R.string.sign_up_btn))
                }
            }
        }
    }
}

fun navigateToMain(navController: NavController, state: SignInState, viewModel: SignInViewModel) {
    navController.navigateClear(BottomNavItem.Home.route)
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
        value = viewModel.nickname
    )
    navController.currentBackStackEntry?.savedStateHandle?.set(
        key = "singleInfo",
        value = viewModel.singleInfo
    )
    navController.currentBackStackEntry?.savedStateHandle?.set(
        key = "specialty",
        value = viewModel.specialty
    )
}

@Composable
fun TitleWithEditTextView(
    title: String,
    value: String,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onChange: (String) -> Unit
) = Column {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
    )
    EditTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChanged = { onChange(it) },
        hint = hint,
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyLarge,
        keyboardType = keyboardType
    )
}

@Preview
@Composable
fun SignInPreview() {
    SoptcomposeTheme {
        SignInPage(navController = rememberNavController())
    }
}
