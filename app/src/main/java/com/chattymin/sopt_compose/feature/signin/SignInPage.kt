package com.chattymin.sopt_compose.feature.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chattymin.sopt_compose.R
import com.chattymin.sopt_compose.components.spacer.VerticalSpacer
import com.chattymin.sopt_compose.components.textfield.EditTextField
import com.chattymin.sopt_compose.components.text.TitleText
import com.chattymin.sopt_compose.ext.addFocusCleaner
import com.chattymin.sopt_compose.navigation.Screen
import com.chattymin.sopt_compose.ui.theme.SoptcomposeTheme

@Composable
fun SignInPage(navController: NavController) {
    val focusManager = LocalFocusManager.current

    val id = remember { mutableStateOf("") }
    val pw = remember { mutableStateOf("") }

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
                .addFocusCleaner(focusManager),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TitleWithEtv(
                title = stringResource(id = R.string.id),
                value = id,
                hint = stringResource(id = R.string.auth_id_hint)
            )

            VerticalSpacer(dp = 20)

            TitleWithEtv(
                title = stringResource(id = R.string.pw),
                value = pw,
                hint = stringResource(id = R.string.auth_pw_hint),
                keyboardType = KeyboardType.Password
            )

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                Button(onClick = {
                    navController.navigate(Screen.SignUp.route)
                }) {
                    Text(text = stringResource(id = R.string.sign_in_btn))
                }
            }
        }
    }
}

@Composable
fun TitleWithEtv(
    title: String,
    value: MutableState<String>,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text
) =
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
        )
        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value.value,
            onValueChanged = { value.value = it },
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
