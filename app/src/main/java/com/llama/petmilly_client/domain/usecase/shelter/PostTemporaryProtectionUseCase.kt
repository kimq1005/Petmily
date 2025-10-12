package com.llama.petmilly_client.domain.usecase.shelter

import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import com.llama.petmilly_client.presentation.shelterWrite.model.GenderType
import com.llama.petmilly_client.presentation.shelterWrite.model.NeuteringType
import com.llama.petmilly_client.presentation.shelterWrite.model.PickUpType
import com.llama.petmilly_client.presentation.shelterWrite.model.VaccinationType
import okhttp3.MultipartBody
import java.time.LocalDateTime

interface PostTemporaryProtectionUseCase {
    suspend operator fun invoke(
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
    ): Result<Boolean>
}