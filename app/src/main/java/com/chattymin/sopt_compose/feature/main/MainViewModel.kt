package com.chattymin.sopt_compose.feature.main

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel: ViewModel(), ContainerHost<MainState, MainSideEffect> {
    override val container = container<MainState, MainSideEffect>(MainState())

    fun valueChanged(
        id: String? = null,
        pw: String? = null,
        nickname: String? = null,
        singleInfo: String? = null,
        specialty: String? = null
    ) = intent {
        reduce {
            state.copy(
                id = id ?: state.id,
                pw = pw ?: state.pw,
                nickname = nickname ?: state.nickname,
                singleInfo = singleInfo ?: state.singleInfo,
                specialty = specialty ?: state.specialty,
            )
        }
    }
}
