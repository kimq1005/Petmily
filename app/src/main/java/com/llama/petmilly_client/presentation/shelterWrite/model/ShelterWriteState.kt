package com.llama.petmilly_client.presentation.shelterWrite.model

import android.net.Uri
import androidx.compose.runtime.Immutable
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import okhttp3.MultipartBody

@Immutable
data class ShelterWriteState(
    val petCategoryType: PetCategoryType? = null,
    val petName: String = "테스트",
    val gender: GenderType? = null,
    val weight: String = "1",
    val species: String = "포메",
    val age: String = "2",
    val health: String = "건강",
    val skill: String = "스킬풀",
    val personality: String = "오호",
    val charmAppeal: String = "테스트",
    val startReceptionPeriod: String = "",
    val endReceptionPeriod: String = "",
    val hopePeoples: List<String> = emptyList(),
    val noPeoples: List<String> = emptyList(),
    val neuteredType: NeuteringType? = null,
    val vaccinationType: VaccinationType? = null,
    val pickUpType: PickUpType? = null,
    val petPhotoFile: List<MultipartBody.Part> = emptyList(),
    val petPhotoUri: List<Uri> = emptyList(),
    val tenancyCondition: List<String> = emptyList()
)