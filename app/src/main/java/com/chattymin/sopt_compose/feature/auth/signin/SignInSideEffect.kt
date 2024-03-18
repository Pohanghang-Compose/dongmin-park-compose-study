package com.chattymin.sopt_compose.feature.auth.signin

sealed class SignInSideEffect {
    data object NavigateToSignUp : SignInSideEffect()
    data object NavigateToMain : SignInSideEffect()
    data object Toast : SignInSideEffect()
}
