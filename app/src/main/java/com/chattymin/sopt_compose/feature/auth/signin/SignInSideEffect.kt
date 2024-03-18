package com.chattymin.sopt_compose.feature.auth.signin

sealed class SignInSideEffect {
    object NavigateToSignUp: SignInSideEffect()
    object NavigateToMain: SignInSideEffect()
    object Toast: SignInSideEffect()
}
