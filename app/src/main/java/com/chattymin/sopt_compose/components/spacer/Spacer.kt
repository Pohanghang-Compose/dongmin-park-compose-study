package com.chattymin.sopt_compose.components.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Spacer(dp: Int) = Spacer(modifier = Modifier.padding(dp.dp))