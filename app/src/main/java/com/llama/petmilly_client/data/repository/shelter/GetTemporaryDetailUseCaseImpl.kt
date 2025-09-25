package com.llama.petmilly_client.data.repository.shelter

import com.llama.petmilly_client.data.model.shelter.toDomain
import com.llama.petmilly_client.data.network.ShelterService
import com.llama.petmilly_client.domain.model.shelter.Temporary
import com.llama.petmilly_client.domain.usecase.shelter.GetTemporaryDetailUseCase
import javax.inject.Inject

class GetTemporaryDetailUseCaseImpl @Inject constructor(
    private val shelterService: ShelterService
): GetTemporaryDetailUseCase {
    override suspend fun invoke(
        id: Int
    ): Result<Temporary> = kotlin.runCatching {
       val data = shelterService.getTemporaryDetail(
            id
        ).body()?.toDomain()

        data ?: throw NullPointerException()
    }
}