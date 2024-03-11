package com.chattymin.sopt_compose.feature.signin

sealed class SignInSideEffect {
    object NavigateToSignUp : SignInSideEffect()
    object NavigateToMain : SignInSideEffect()
    data class Toast(val message: String) : SignInSideEffect()
}
