package com.llama.petmilly_client.domain.usecase.home

import com.llama.petmilly_client.domain.model.home.Library

interface GetLibraryUseCase {
    suspend operator fun invoke(
        key: String,
        startIndex: Int,
        endIndex: Int,
    ): Result<Library>
}