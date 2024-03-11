package com.chattymin.sopt_compose.feature.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chattymin.sopt_compose.R

@Composable
fun MainPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
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
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Text(text = "이름")
            Spacer(modifier = Modifier.padding(horizontal = 12.dp))
            Text(text = "한줄 자기소개")
        }
        Spacer(modifier = Modifier.padding(vertical = 20.dp))

        TitleWithText(title = stringResource(id = R.string.id), text = "chattymin")

        Spacer(modifier = Modifier.padding(vertical = 12.dp))

        TitleWithText(title = "특기", text = "침대와 교감하기")
    }
}

@Composable
fun TitleWithText(title: String, text: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
    )
    Spacer(modifier = Modifier.padding(vertical = 4.dp))
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Gray
    )
}