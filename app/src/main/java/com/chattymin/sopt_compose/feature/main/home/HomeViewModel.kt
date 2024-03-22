package com.chattymin.sopt_compose.feature.main.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class HomeViewModel : ViewModel(), ContainerHost<HomeState, HomeSideEffect> {
    override val container = container<HomeState, HomeSideEffect>(HomeState())

    val data = listOf(
        Friend(
            picture = Icons.Filled.Home,
            name = "박동민",
            comment = "스터디장도 과제를 해야한다는건 편견이 아닐까... 아~ 하기싫다~",
        ),
        Friend(
            picture = Icons.Filled.Face,
            name = "강유리",
            hasMusic = Music(
                artist = "최유리",
                title = "동그라미"
            )
        ),
        Friend(
            picture = Icons.Filled.Build,
            name = "박강희",
            comment = "퇴사하고싶어요",
        ),
        Friend(
            picture = Icons.Filled.Phone,
            name = "조관희",
            comment = "일어나... 하체해야지",
            isBirthDay = true
        ),
        Friend(
            picture = Icons.Filled.Lock,
            name = "이태희",
            comment = "포항항 스터디로 정상에 오르고 싶습니다",
            hasMusic = Music(
                artist = "한사랑 산악회",
                title = "열정,열정,열정!"
            ),
            isBirthDay = true
        ),
        Friend(
            picture = Icons.Filled.Warning,
            name = "더이상 친구가 없어요",
            comment = "더미더미더미더미",
            hasMusic = Music(
                artist = "더미더미",
                title = "더미"
            )
        ),
        Friend(
            picture = Icons.Filled.Warning,
            name = "더이상 친구가 없어요",
            comment = "더미더미더미더미",
            hasMusic = Music(
                artist = "더미더미",
                title = "더미"
            )
        ),
        Friend(
            picture = Icons.Filled.Warning,
            name = "더이상 친구가 없어요",
            comment = "더미더미더미더미",
            hasMusic = Music(
                artist = "더미더미",
                title = "더미"
            )
        ),
        Friend(
            picture = Icons.Filled.Warning,
            name = "더이상 친구가 없어요",
            comment = "더미더미더미더미",
            hasMusic = Music(
                artist = "더미더미",
                title = "더미"
            )
        ),
        Friend(
            picture = Icons.Filled.Warning,
            name = "더이상 친구가 없어요",
            comment = "더미더미더미더미",
            hasMusic = Music(
                artist = "더미더미",
                title = "더미"
            )
        ),
        Friend(
            picture = Icons.Filled.Warning,
            name = "더이상 친구가 없어요",
            comment = "더미더미더미더미",
            hasMusic = Music(
                artist = "더미더미",
                title = "더미"
            )
        ),
        Friend(
            picture = Icons.Filled.Warning,
            name = "더이상 친구가 없어요",
            comment = "더미더미더미더미",
            hasMusic = Music(
                artist = "더미더미",
                title = "더미"
            )
        ),
    )
}

data class Friend(
    val picture: ImageVector,
    val name: String,
    val comment: String = "",
    val isBirthDay: Boolean = false,
    val hasMusic: Music? = null
)

data class Music(
    val artist: String,
    val title: String
)
