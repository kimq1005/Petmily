package com.llama.petmilly_client.presentation.shelter.model

enum class ShelterSafeCategoryType(
    val title: String,
    val code: String
) {
    PUPPY("강아지", "DOG"),
    CAT("고양이", "CAT"),
    ENTITY("petmilly ❤️", "ENTITY"),
    SMALL("~7kg", "SMALL"),
    MIDDLE("7~15kg", "MIDDLE"),
    BIG("15kg~", "BIG")
}
