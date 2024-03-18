package com.chattymin.sopt_compose.feature.auth.signup

sealed class SignUpSideEffect {
    object NavigateToSignUp: SignUpSideEffect()
    object Toast: SignUpSideEffect()
}