package com.chattymin.sopt_compose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun EditTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    hint: String = "",
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
) {
    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChanged(it) },
        textStyle = textStyle
    ) { innerTextField ->
        Column {
            Box {
                innerTextField()
                if (value.isEmpty()) {
                    Text(
                        text = hint,
                        style = textStyle,
                        color = Color.LightGray,
                    )
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            Divider(
                thickness = 1.dp,
                color = Color.Black
            )
        }
    }
}
