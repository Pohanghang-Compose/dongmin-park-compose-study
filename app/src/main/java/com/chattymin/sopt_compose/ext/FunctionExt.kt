package com.chattymin.sopt_compose.ext

import android.content.Context
import android.widget.Toast

fun toast(context: Context, message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
