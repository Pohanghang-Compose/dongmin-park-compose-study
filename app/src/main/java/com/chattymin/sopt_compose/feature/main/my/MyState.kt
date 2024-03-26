package com.chattymin.sopt_compose.feature.main.my

data class MyState(
    val showDialog: Boolean = false,
    val id: String = "",
    val pw: String = "",
    val nickname: String = "",
    val singleInfo: String = "",
    val specialty: String = "",
)
