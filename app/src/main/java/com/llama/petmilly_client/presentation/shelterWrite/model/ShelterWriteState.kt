package com.llama.petmilly_client.presentation.shelterWrite.model

import android.net.Uri
import androidx.compose.runtime.Immutable
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import okhttp3.MultipartBody

@Immutable
data class ShelterWriteState(
    val petCategoryType: PetCategoryType = PetCategoryType.ENTITY,
    val petName: String = "",
    val gender: GenderType? = null,
    val weight: String = "",
    val species: String = "",
    val age: String = "",
    val petPhotoFile: List<MultipartBody.Part> = emptyList(),
    val petPhotoUri: List<Uri> = emptyList()
)