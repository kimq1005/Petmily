package com.llama.petmilly_client.data.repository.shelter

import com.llama.petmilly_client.data.model.shelter.toDomain
import com.llama.petmilly_client.data.network.ShelterService
import com.llama.petmilly_client.domain.model.shelter.Post
import com.llama.petmilly_client.domain.usecase.shelter.GetShelterPostUseCase
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeCategoryType
import javax.inject.Inject

class GetShelterPostUseCaseImpl @Inject constructor(
    private val shelterService: ShelterService,
): GetShelterPostUseCase {
    override suspend fun invoke(
        page: Int,
        limit: Int,
        cat: Boolean,
        dog: Boolean,
        isComplete: Boolean,
        weight: List<ShelterSafeCategoryType>,
        type: String,
    ): Result<Post> = kotlin.runCatching {
        val data = shelterService.getShelterPost(
            page = page,
            limit = limit,
            cat = cat,
            dog = dog,
            isComplete = isComplete,
            weight = weight,
            type = type
        ).body()?.toDomain()

        data ?: throw NullPointerException()
    }

}