package com.chattymin.sopt_compose.feature.auth.signup

sealed class SignUpSideEffect {
    data object NavigateToSignUp: SignUpSideEffect()
    data object Toast: SignUpSideEffect()
}
