package com.chattymin.sopt_compose.feature.signup

import com.chattymin.sopt_compose.feature.signin.SignInSideEffect

sealed class SignUpSideEffect {
    object NavigateToSignUp : SignUpSideEffect()
    data class Toast(val message: String) : SignUpSideEffect()
}