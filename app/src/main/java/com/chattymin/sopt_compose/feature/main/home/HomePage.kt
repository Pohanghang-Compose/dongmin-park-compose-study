package com.chattymin.sopt_compose.feature.main.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chattymin.sopt_compose.ui.theme.SoptcomposeTheme

@Composable
fun HomePage(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: HomeViewModel = viewModel()

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(viewModel.data) { index, friend ->
            if (index == 0) {
                MyView(friend = friend)
            } else {
                FriendView(friend = friend)
            }
        }
    }
}

@Composable
fun MyView(
    friend: Friend,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(80.dp),
                imageVector = friend.picture,
                contentDescription = friend.name
            )
            Column {
                Text(
                    text = friend.name + if (friend.isBirthDay) " 🎂" else "",
                    maxLines = 1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = friend.comment,
                    maxLines = 1,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Thin,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        when {
            friend.isBirthDay -> BirthDayCard()
            friend.hasMusic != null -> MusicCard(friend.hasMusic)
            else -> AddTextCard()
        }
    }
}

@Composable
fun FriendView(
    friend: Friend,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(60.dp),
                imageVector = friend.picture,
                contentDescription = friend.name
            )
            Column {
                Text(
                    text = friend.name + if (friend.isBirthDay) " 🎂" else "",
                    maxLines = 1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = friend.comment,
                    maxLines = 1,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Thin,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        when {
            friend.isBirthDay -> BirthDayCard()
            friend.hasMusic != null -> MusicCard(friend.hasMusic)
        }
    }
}

@Composable
fun BirthDayCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(1.dp, Color.Red)

    ) {
        Text(
            text = "선물하기 🎁",
            fontSize = 12.sp,
            modifier = Modifier.padding(4.dp),
        )
    }
}

@Composable
fun MusicCard(music: Music) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(1.dp, Color.Green)

    ) {
        Text(
            text = "${music.artist} - ${music.title} ▶️",
            fontSize = 12.sp,
            modifier = Modifier.padding(4.dp),
        )
    }
}

@Composable
fun AddTextCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(1.dp, Color.LightGray)

    ) {
        Text(
            text = "상태 메시지 +",
            fontSize = 12.sp,
            modifier = Modifier.padding(4.dp),
        )
    }
}

@Preview
@Composable
fun FriendViewPreview() {
    SoptcomposeTheme {
        val viewModel: HomeViewModel = viewModel()
        LazyColumn {
            items(viewModel.data) { friend ->
                FriendView(
                    friend = friend
                )
            }
        }
    }
}

