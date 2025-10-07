package com.llama.petmilly_client.presentation.shelterWrite.model

enum class VaccinationType(val title: String) {
    UN_VACCINATED(title = "미접종"),
    FIRST_COMPLETED(title = "1차 완료"),
    SECOND_COMPLETED(title = "2차 완료"),
    UNKNOWN("모르겠어요")
}