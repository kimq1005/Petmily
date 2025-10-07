package com.llama.petmilly_client.presentation.shelterWrite.model

enum class NeuteringType(val title: String) {
    NEUTERED(title = "중성화 O"),
    UN_NEUTERED(title = "중성화 X"),
    UNKNOWN(title = "모르겠어요.")
}