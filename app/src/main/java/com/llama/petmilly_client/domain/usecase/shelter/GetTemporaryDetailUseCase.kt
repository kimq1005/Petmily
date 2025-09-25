package com.llama.petmilly_client.domain.usecase.shelter

import com.llama.petmilly_client.domain.model.shelter.Temporary

interface GetTemporaryDetailUseCase {
    suspend operator fun invoke(
        id: Int,
    ): Result<Temporary>
}