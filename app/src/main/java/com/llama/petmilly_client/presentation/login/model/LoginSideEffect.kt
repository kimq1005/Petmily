package com.llama.petmilly_client.presentation.login.model

sealed interface LoginSideEffect {
    class Error(val message: String): LoginSideEffect
    object NavigateToHomeActivity: LoginSideEffect
    object NavigateToNotificationActivity: LoginSideEffect
}