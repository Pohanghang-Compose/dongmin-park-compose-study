package com.chattymin.sopt_compose.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

open class BaseViewModel<T : Any> (
    appState: MutableStateFlow<AppState>,
) : ViewModel(), ContainerHost<MutableStateFlow<AppState>, T> {
    override val container = container<MutableStateFlow<AppState>, T>(appState)
}