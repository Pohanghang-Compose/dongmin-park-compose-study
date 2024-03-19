package com.chattymin.sopt_compose.feature.main.my

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MyViewModel: ViewModel(), ContainerHost<MyState, MySideEffect> {
    override val container = container<MyState, MySideEffect>(MyState())

    fun signOut() = intent {
        postSideEffect(MySideEffect.SignOut)
        postSideEffect(MySideEffect.Toast)
    }

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
