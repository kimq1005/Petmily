package com.llama.petmilly_client.presentation.login.model

import androidx.compose.runtime.Immutable

@Immutable
data class LoginState(
    val id: String = "",
    val password: String = "",
)