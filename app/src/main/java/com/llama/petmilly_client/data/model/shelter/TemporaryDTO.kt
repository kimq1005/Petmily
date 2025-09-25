package com.llama.petmilly_client.data.model.shelter

import com.google.gson.annotations.SerializedName
import com.llama.petmilly_client.domain.model.shelter.ProtectionCondition
import com.llama.petmilly_client.domain.model.shelter.ProtectionHope
import com.llama.petmilly_client.domain.model.shelter.ProtectionNo
import com.llama.petmilly_client.domain.model.shelter.Temporary
import com.llama.petmilly_client.domain.model.shelter.TemporaryAddressInfo
import com.llama.petmilly_client.domain.model.shelter.TemporaryCompleteUser
import com.llama.petmilly_client.domain.model.shelter.TemporaryDetail
import com.llama.petmilly_client.domain.model.shelter.TemporaryPhotoUrl
import com.llama.petmilly_client.domain.model.shelter.TemporaryThumbnail
import com.llama.petmilly_client.domain.model.shelter.TemporaryUser

data class TemporaryDTO(
    @SerializedName("data") val data: TemporaryDetailDTO,
    @SerializedName("success") val success: Boolean,
)

data class TemporaryDetailDTO(
    @SerializedName("protectionCondition") val protectionCondition: List<ProtectionConditionDTO>,
    @SerializedName("protectionHope") val protectionHope: List<ProtectionHopeDTO>,
    @SerializedName("protectionNo") val protectionNo: List<ProtectionNoDTO>,
    @SerializedName("addressInfo") val addressInfo: TemporaryAddressInfoDTO,
    @SerializedName("age") val age: Double,
    @SerializedName("animalTypes") val animalTypes: String,
    @SerializedName("breed") val breed: String,
    @SerializedName("character") val character: String,
    @SerializedName("charmAppeal") val charmAppeal: String,
    @SerializedName("completeUser") val completeUser: TemporaryCompleteUserDTO,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("health") val health: String,
    @SerializedName("id") val id: Int,
    @SerializedName("inoculation") val inoculation: String,
    @SerializedName("isComplete") val isComplete: Boolean,
    @SerializedName("isReceipt") val isReceipt: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("neutered") val neutered: String,
    @SerializedName("photoUrls") val photoUrls: List<TemporaryPhotoUrlDTO>,
    @SerializedName("pickUp") val pickUp: String,
    @SerializedName("receptionPeriod") val receptionPeriod: String,
    @SerializedName("skill") val skill: String,
    @SerializedName("thumbnail") val thumbnail: TemporaryThumbnailDTO?,
    @SerializedName("user") val user: TemporaryUserDTO,
    @SerializedName("weight") val weight: Int,
)

data class ProtectionConditionDTO(
    @SerializedName("content") val content: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("id") val id: Int,
    @SerializedName("isDeleted") val isDeleted: Boolean,
)

data class ProtectionHopeDTO(
    @SerializedName("content") val content: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("id") val id: Int,
    @SerializedName("isDeleted") val isDeleted: Boolean,
)

data class ProtectionNoDTO(
    @SerializedName("content") val content: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("id") val id: Int,
    @SerializedName("isDeleted") val isDeleted: Boolean,
)

data class TemporaryAddressInfoDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("longName") val longName: String,
    @SerializedName("shortName") val shortName: String,
)

data class TemporaryCompleteUserDTO(
    @SerializedName("id") val id: Int,
)

data class TemporaryPhotoUrlDTO(
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("id") val id: Int,
    @SerializedName("isDeleted") val isDeleted: Boolean,
    @SerializedName("photoUrl") val photoUrl: String,
)

data class TemporaryThumbnailDTO(
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("id") val id: Int,
    @SerializedName("isDeleted") val isDeleted: Boolean,
    @SerializedName("photoUrl") val photoUrl: String,
)

data class TemporaryUserDTO(
    @SerializedName("id") val id: Int,
)

fun TemporaryDTO.toDomain(): Temporary {
    return Temporary(
        data = this.data.toDomain(),
        success = this.success
    )
}

fun TemporaryDetailDTO.toDomain(): TemporaryDetail {
    return TemporaryDetail(
        protectionCondition = this.protectionCondition.map { it.toDomain() },
        protectionHope = this.protectionHope.map { it.toDomain() },
        protectionNo = this.protectionNo.map { it.toDomain() },
        addressInfo = this.addressInfo.toDomain(),
        age = this.age,
        animalTypes = this.animalTypes,
        breed = this.breed,
        character = this.character,
        charmAppeal = this.charmAppeal,
        completeUser = this.completeUser.toDomain(),
        createdAt = this.createdAt,
        gender = this.gender,
        health = this.health,
        id = this.id,
        inoculation = this.inoculation,
        isComplete = this.isComplete,
        isReceipt = this.isReceipt,
        name = this.name,
        neutered = this.neutered,
        photoUrls = this.photoUrls.map { it.toDomain() },
        pickUp = this.pickUp,
        receptionPeriod = this.receptionPeriod,
        skill = this.skill,
        thumbnail = this.thumbnail?.toDomain(),
        user = this.user.toDomain(),
        weight = this.weight
    )
}

fun ProtectionConditionDTO.toDomain() = ProtectionCondition(
    content = this.content,
    createdAt = this.createdAt,
    id = this.id,
    isDeleted = this.isDeleted
)

fun ProtectionHopeDTO.toDomain() = ProtectionHope(
    content = this.content,
    createdAt = this.createdAt,
    id = this.id,
    isDeleted = this.isDeleted
)

fun ProtectionNoDTO.toDomain() = ProtectionNo(
    content = this.content,
    createdAt = this.createdAt,
    id = this.id,
    isDeleted = this.isDeleted
)

fun TemporaryAddressInfoDTO.toDomain() = TemporaryAddressInfo(
    id = this.id,
    longName = this.longName,
    shortName = this.shortName
)

fun TemporaryCompleteUserDTO.toDomain() = TemporaryCompleteUser(
    id = this.id
)

fun TemporaryPhotoUrlDTO.toDomain() = TemporaryPhotoUrl(
    createdAt = this.createdAt,
    id = this.id,
    isDeleted = this.isDeleted,
    photoUrl = this.photoUrl
)

fun TemporaryThumbnailDTO.toDomain() = TemporaryThumbnail(
    createdAt = this.createdAt,
    id = this.id,
    isDeleted = this.isDeleted,
    photoUrl = this.photoUrl
)

fun TemporaryUserDTO.toDomain() = TemporaryUser(
    id = this.id
)