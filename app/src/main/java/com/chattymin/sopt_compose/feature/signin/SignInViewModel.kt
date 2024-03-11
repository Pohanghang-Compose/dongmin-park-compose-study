package com.chattymin.sopt_compose.feature.signin

import com.chattymin.sopt_compose.base.AppState
import com.chattymin.sopt_compose.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

@HiltViewModel
class SignInViewModel constructor(
    appState: MutableStateFlow<AppState>,
) : BaseViewModel<SignInSideEffect>(appState) {

    fun navigateToSignUpPage() {
        intent {
            postSideEffect(SignInSideEffect.NavigateToSignUp)
        }
    }
}
