package com.chattymin.sopt_compose.feature.signin

import android.util.Log
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
import com.chattymin.sopt_compose.components.spacer.HorizontalSpacer
import com.chattymin.sopt_compose.components.spacer.VerticalSpacer
import com.chattymin.sopt_compose.components.text.TitleText
import com.chattymin.sopt_compose.components.textfield.EditTextField
import com.chattymin.sopt_compose.ext.addFocusCleaner
import com.chattymin.sopt_compose.ext.toast
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
        navController.previousBackStackEntry.let {
            val id = it?.savedStateHandle?.get<String>("id") ?: ""
            val pw = it?.savedStateHandle?.get<String>("pw") ?: ""
            val nickname = it?.savedStateHandle?.get<String>("nickname") ?: ""
            val singleInfo = it?.savedStateHandle?.get<String>("singleInfo") ?: ""
            val specialty = it?.savedStateHandle?.get<String>("specialty") ?: ""

            Log.e("TAG", "SignInPage: $id, $pw, $nickname, $singleInfo, $specialty")
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
            TitleWithEtv(
                title = stringResource(id = R.string.id),
                value = state.id,
                hint = stringResource(id = R.string.auth_id_hint)
            ) {
                viewModel.idChanged(it)
            }

            VerticalSpacer(dp = 20)

            TitleWithEtv(
                title = stringResource(id = R.string.pw),
                value = state.pw,
                hint = stringResource(id = R.string.auth_pw_hint),
                keyboardType = KeyboardType.Password
            ) {
                viewModel.pwChanged(it)
            }

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    enabled = state.canLogin,
                    onClick = {
                        viewModel.signInButtonClicked()
                    }
                ) {
                    Text(text = stringResource(id = R.string.sign_in_btn))
                }

                HorizontalSpacer(dp = 4)

                Button(
                    onClick = { viewModel.navigateToSignUpPage() }
                ) {
                    Text(text = stringResource(id = R.string.sign_up_btn))
                }
            }
        }
    }

    viewModel.collectSideEffect {
        when (it) {
            SignInSideEffect.NavigateToMain -> navController.navigate(Screen.Main.route)
            SignInSideEffect.NavigateToSignUp -> navController.navigate(Screen.SignUp.route)
            is SignInSideEffect.Toast -> toast(context, it.message)
        }
    }
}

@Composable
fun TitleWithEtv(
    title: String,
    value: String,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onChange: (String) -> Unit
) =
    Column {
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
