package com.chattymin.sopt_compose.feature.main.my

import com.chattymin.sopt_compose.feature.auth.signin.SignInSideEffect

sealed class MySideEffect {
    data object SignOut: MySideEffect()
}
