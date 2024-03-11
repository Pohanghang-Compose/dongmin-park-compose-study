package com.chattymin.sopt_compose.feature.signin

sealed class SignInSideEffect {
    object NavigateToSignUp: SignInSideEffect()
    object NavigateToMain: SignInSideEffect()
    object Toast: SignInSideEffect()
}
