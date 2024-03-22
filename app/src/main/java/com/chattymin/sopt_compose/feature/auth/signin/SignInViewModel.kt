package com.chattymin.sopt_compose.feature.auth.signin

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class SignInViewModel: ViewModel(), ContainerHost<SignInState, SignInSideEffect> {
    override val container = container<SignInState, SignInSideEffect>(SignInState())
    var nickname: String = ""
    var singleInfo: String = ""
    var specialty: String = ""

    fun valueChanged(
        id: String? = null,
        pw: String? = null,
    ) = intent {
        reduce {
            state.copy(
                id = id ?: state.id,
                pw = pw ?: state.pw,
                canSignIn = canSignIn(
                    id ?: state.id,
                    pw ?: state.pw,
                )
            )
        }
    }

    fun canSignIn(id: String, pw: String) = id.isNotEmpty() && pw.isNotEmpty()

    fun signInButtonClicked() {
        makeToast()
        navigateToMainPage()
    }

    fun navigateToSignUpPage() = intent {
        postSideEffect(SignInSideEffect.NavigateToSignUp)
    }

    private fun navigateToMainPage() = intent {
        postSideEffect(SignInSideEffect.NavigateToMain)
    }


    private fun makeToast() = intent {
        postSideEffect(SignInSideEffect.Toast)
    }
}
