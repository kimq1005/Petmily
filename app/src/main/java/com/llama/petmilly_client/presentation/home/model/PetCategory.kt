package com.llama.petmilly_client.presentation.home.model

enum class PetCategory(
    val title: String,
    val code: String
) {
    PUPPY("강아지", "DOG"),
    CAT("고양이", "CAT"),
    ENTITY("petmilly ❤️", "ENTITY"),
}