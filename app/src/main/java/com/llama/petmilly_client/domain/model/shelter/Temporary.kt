package com.llama.petmilly_client.domain.model.shelter

data class Temporary(
    val data: TemporaryDetail,
    val success: Boolean
)

data class TemporaryDetail(
    val protectionCondition: List<ProtectionCondition>,
    val protectionHope: List<ProtectionHope>,
    val protectionNo: List<ProtectionNo>,
    val addressInfo: TemporaryAddressInfo,
    val age: Double,
    val animalTypes: String,
    val breed: String,
    val character: String,
    val charmAppeal: String,
    val completeUser: TemporaryCompleteUser,
    val createdAt: String,
    val gender: String,
    val health: String,
    val id: Int,
    val inoculation: String,
    val isComplete: Boolean,
    val isReceipt: Boolean,
    val name: String,
    val neutered: String,
    val photoUrls: List<TemporaryPhotoUrl>,
    val pickUp: String,
    val receptionPeriod: String,
    val skill: String,
    val thumbnail: TemporaryThumbnail?,
    val user: TemporaryUser,
    val weight: Int
)

data class ProtectionCondition(
    val content: String,
    val createdAt: String,
    val id: Int,
    val isDeleted: Boolean
)

data class ProtectionHope(
    val content: String,
    val createdAt: String,
    val id: Int,
    val isDeleted: Boolean
)

data class ProtectionNo(
    val content: String,
    val createdAt: String,
    val id: Int,
    val isDeleted: Boolean
)

data class TemporaryAddressInfo(
    val id: Int,
    val longName: String,
    val shortName: String
)

data class TemporaryCompleteUser(
    val id: Int
)

data class TemporaryPhotoUrl(
    val createdAt: String,
    val id: Int,
    val isDeleted: Boolean,
    val photoUrl: String
)

data class TemporaryThumbnail(
    val createdAt: String,
    val id: Int,
    val isDeleted: Boolean,
    val photoUrl: String
)

data class TemporaryUser(
    val id: Int
)