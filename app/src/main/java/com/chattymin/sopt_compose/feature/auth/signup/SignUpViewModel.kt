package com.chattymin.sopt_compose.feature.auth.signup

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class SignUpViewModel : ViewModel(), ContainerHost<SignUpState, SignUpSideEffect> {
    override val container = container<SignUpState, SignUpSideEffect>(SignUpState())
    fun signUpBtnClicked() {
        navigateToSignUpPage()
        makeToast()
    }

    private fun navigateToSignUpPage() = intent {
        postSideEffect(SignUpSideEffect.NavigateToSignUp)
    }


    private fun makeToast() = intent {
        postSideEffect(SignUpSideEffect.Toast)
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
                canSignUp = canSignUp(
                    id ?: state.id,
                    pw ?: state.pw,
                    nickname ?: state.nickname,
                    singleInfo ?: state.singleInfo,
                    specialty ?: state.specialty
                )
            )
        }
    }

    private fun canSignUp(
        id: String,
        pw: String,
        nickname: String,
        singleInfo: String,
        specialty: String
    ) =
        id.isNotEmpty() && pw.isNotEmpty() && nickname.isNotEmpty() && singleInfo.isNotEmpty() && specialty.isNotEmpty()
}