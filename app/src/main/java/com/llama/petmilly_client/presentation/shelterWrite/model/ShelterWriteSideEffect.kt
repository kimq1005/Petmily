package com.llama.petmilly_client.presentation.shelterWrite.model

sealed interface ShelterWriteSideEffect{
    class Error(val message: String): ShelterWriteSideEffect
}