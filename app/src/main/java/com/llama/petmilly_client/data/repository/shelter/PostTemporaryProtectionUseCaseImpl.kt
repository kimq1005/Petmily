package com.llama.petmilly_client.data.repository.shelter

import com.llama.petmilly_client.data.network.ShelterService
import com.llama.petmilly_client.domain.usecase.shelter.PostTemporaryProtectionUseCase
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import com.llama.petmilly_client.presentation.shelterWrite.model.GenderType
import com.llama.petmilly_client.presentation.shelterWrite.model.NeuteringType
import com.llama.petmilly_client.presentation.shelterWrite.model.PickUpType
import com.llama.petmilly_client.presentation.shelterWrite.model.VaccinationType
import okhttp3.MultipartBody
import java.time.LocalDateTime
import javax.inject.Inject

class PostTemporaryProtectionUseCaseImpl @Inject constructor(
    private val shelterService: ShelterService,
) : PostTemporaryProtectionUseCase {
    override suspend fun invoke(
        files: List<MultipartBody.Part>?,
        charmAppeal: String,
        animalTypes: PetCategoryType,
        name: String,
        gender: GenderType,
        weight: String,
        breed: String,
        age: String,
        neutered: NeuteringType,
        inoculation: VaccinationType,
        health: String?,
        skill: String?,
        character: String?,
        pickUp: PickUpType,
        startReceptionPeriod: LocalDateTime?,
        endReceptionPeriod: LocalDateTime?,
        temporaryProtectionCondition: List<String>?,
        temporaryProtectionHope: List<String>?,
        temporaryProtectionNo: List<String>?,
    ): Result<Boolean> = kotlin.runCatching {

        val data = shelterService.postTemporaryProtection(
            files,
            charmAppeal,
            animalTypes,
            name,
            gender,
            weight,
            breed,
            age,
            neutered,
            inoculation,
            health,
            skill,
            character,
            pickUp,
            startReceptionPeriod,
            endReceptionPeriod,
            temporaryProtectionCondition,
            temporaryProtectionHope,
            temporaryProtectionNo
        ).body()

        data ?: throw NullPointerException()
    }
}