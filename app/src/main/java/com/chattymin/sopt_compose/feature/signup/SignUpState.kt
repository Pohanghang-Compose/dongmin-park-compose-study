package com.chattymin.sopt_compose.feature.signup

data class SignUpState(
    val id: String = "",
    val pw: String = "",
    val nickname: String = "",
    val singleInfo: String = "",
    val specialty: String = "",
    val canSignUp: Boolean = false
)
