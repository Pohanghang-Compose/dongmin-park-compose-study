package com.chattymin.sopt_compose.base

import com.chattymin.sopt_compose.feature.signin.SignInState

data class AppState(
    val signInState: SignInState = SignInState(),
)