package com.chattymin.sopt_compose.feature.main.my

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.chattymin.sopt_compose.R
import com.chattymin.sopt_compose.components.spacer.Spacer
import com.chattymin.sopt_compose.ext.navigateClear
import com.chattymin.sopt_compose.ext.toast
import com.chattymin.sopt_compose.navigation.Screen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MyPage(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: MyViewModel = viewModel()

    val state by viewModel.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        navController.previousBackStackEntry?.savedStateHandle?.run {
            viewModel.valueChanged(
                id = get<String>("id") ?: "",
                pw = get<String>("pw") ?: "",
                nickname = get<String>("nickname") ?: "",
                singleInfo = get<String>("singleInfo") ?: "",
                specialty = get<String>("specialty") ?: ""
            )
        }
    }

    viewModel.collectSideEffect {
        when (it) {
            MySideEffect.SignOut -> navController.navigateClear(Screen.SignIn.route)
            MySideEffect.Toast -> toast(context, context.getString(R.string.sign_out_success))
        }
    }

    if (state.showDialog) {
        SettingDialog(
            onDismiss = {
                viewModel.settingButtonClicked()
            }
        )
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { viewModel.settingButtonClicked() }) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "Setting")
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.signOut() }) {
                Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "SignOut")
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .padding(it),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = ImageRequest.Builder(context).data(R.drawable.img_profile)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    error = painterResource(id = R.drawable.ic_launcher_background),
                    modifier = Modifier
                        .size(60.dp)
                        .padding(5.dp)
                        .clip(shape = RoundedCornerShape(40.dp))
                )
                Spacer(dp = 8)
                Text(text = state.nickname)
                Spacer(dp = 12)
                Text(text = state.singleInfo)
            }
            Spacer(dp = 20)

            TitleWithText(title = stringResource(id = R.string.id), text = state.id)

            Spacer(dp = 20)

            TitleWithText(title = stringResource(id = R.string.specialty), text = state.specialty)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingDialog(
    onDismiss: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        modifier = Modifier.fillMaxHeight(0.3f)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "넣을게 없네요~")
        }

    }
}

@Composable
fun TitleWithText(title: String, text: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
    )
    Spacer(dp = 4)
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Gray
    )
}
