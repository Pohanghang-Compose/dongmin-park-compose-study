package com.chattymin.sopt_compose.feature.auth.signin

data class SignInState(
    val id: String = "",
    val pw: String = "",
    val canSignIn: Boolean = false
)
