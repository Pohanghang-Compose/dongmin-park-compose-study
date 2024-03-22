package com.chattymin.sopt_compose.feature.main.my


sealed class MySideEffect {
    data object SignOut: MySideEffect()
    data object Toast: MySideEffect()
}
