package com.llama.petmilly_client.presentation.shelter.model

interface ShelterDetailSideEffect {
    class Error(val message: String): ShelterDetailSideEffect
}