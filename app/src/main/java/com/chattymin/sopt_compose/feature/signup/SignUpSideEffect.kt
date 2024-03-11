package com.chattymin.sopt_compose.feature.signup

sealed class SignUpSideEffect {
    object NavigateToSignUp: SignUpSideEffect()
    object Toast: SignUpSideEffect()
}