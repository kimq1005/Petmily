package com.llama.petmilly_client.presentation.shelterWrite.model

enum class GenderType(
    val gender: String,
    val code: String,
) {
    MALE(gender = "수컷", code = "male"),
    FEMALE(gender = "암컷", code = "female"),
    UNKNOWN(gender = "모름", code = "unknown")
}