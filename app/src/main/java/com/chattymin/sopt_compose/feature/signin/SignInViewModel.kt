package com.chattymin.sopt_compose.feature.signin

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class SignInViewModel: ViewModel(), ContainerHost<SignInState, SignInSideEffect> {
    override val container = container<SignInState, SignInSideEffect>(SignInState())
    fun signInButtonClicked() {
        makeToast("로그인 성공!!")
        navigateToMainPage()
    }

    fun idChanged(id: String) = intent {
        reduce {
            state.copy(
                id = id,
                pw = state.pw,
                canLogin = canLogin(id, state.pw)
            )
        }
    }

    fun pwChanged(pw: String) = intent {
        reduce {
            state.copy(
                id = state.id,
                pw = pw,
                canLogin = canLogin(state.id, pw)
            )
        }
    }

    private fun canLogin(id: String, pw: String) = id.isNotEmpty() && pw.isNotEmpty()

    fun navigateToSignUpPage() = intent {
        postSideEffect(SignInSideEffect.NavigateToSignUp)
    }

    private fun navigateToMainPage() = intent {
        postSideEffect(SignInSideEffect.NavigateToMain)
    }


    private fun makeToast(message: String) = intent {
        postSideEffect(SignInSideEffect.Toast(message))
    }
}
