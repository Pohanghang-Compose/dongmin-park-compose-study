package com.chattymin.sopt_compose.feature.main.home

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class HomeViewModel : ViewModel(), ContainerHost<HomeState, HomeSideEffect> {
    override val container = container<HomeState, HomeSideEffect>(HomeState())

}