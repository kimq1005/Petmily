package com.llama.petmilly_client.presentation.home.model

sealed interface HomeSideEffect {
    class Error(val message: String): HomeSideEffect
    class NavigateToActivity(val shelterCategory: ShelterCategory): HomeSideEffect // Todo: 각 Activity Compose화 후 NavHost로 변경예정
}