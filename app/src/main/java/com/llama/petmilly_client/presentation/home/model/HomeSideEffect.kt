package com.llama.petmilly_client.presentation.home.model

sealed interface HomeSideEffect {
    class Error(val message: String): HomeSideEffect
}