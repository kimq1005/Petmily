package com.llama.petmilly_client.domain.usecase.shelter

import com.llama.petmilly_client.domain.model.shelter.LocationAuthentication
import com.llama.petmilly_client.domain.model.shelter.TemporaryProtection

interface PostTownAuthUseCase {
    suspend operator fun invoke(
        locationAuthentication: LocationAuthentication
    ): Result<TemporaryProtection>
}