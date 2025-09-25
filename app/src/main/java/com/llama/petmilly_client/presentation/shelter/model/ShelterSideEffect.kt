package com.llama.petmilly_client.presentation.shelter.model


sealed interface ShelterSideEffect {
    class Error(val message: String): ShelterSideEffect
    object NavigateToActivity: ShelterSideEffect
}