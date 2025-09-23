package com.llama.petmilly_client.presentation.home.model

enum class ShelterCategory(
    val title: String,
    val code: String
) {
    SAVE_SHELTER("임보처구해요", "SAVE_SHELTER"),
    FIND_MY_BABY("우리아이 찾아요", "FIND_MY_BABY"),
    MOVE_VOLUNTEER("이동봉사 찾아요", "MOVE_VOLUNTEER"),
    ADOPTION_NOTICE("입양 공고", "ADOPTION_NOTICE")
}