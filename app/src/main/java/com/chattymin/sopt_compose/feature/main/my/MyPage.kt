package com.chattymin.sopt_compose.feature.main.my

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chattymin.sopt_compose.R
import com.chattymin.sopt_compose.components.spacer.Spacer
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MyPage(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: MyViewModel = viewModel()

    val state by viewModel.collectAsState()

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

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Text(text = "logout")
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
                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.img_profile),
                    contentScale = ContentScale.Crop,
                    contentDescription = "profile image"
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
