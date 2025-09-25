package com.llama.petmilly_client.data.model.temporary.detail

data class TemporaryDetailDTO(
    val `data`: Data,
    val success: Boolean
)

data class Data(
    val protectionCondition: List<ProtectionCondition>,
    val protectionHope: List<ProtectionHope>,
    val protectionNo: List<ProtectionNo>,
    val addressInfo: AddressInfo,
    val age: Double,
    val animalTypes: String,
    val breed: String,
    val character: String,
    val charmAppeal: String,
    val completeUser: CompleteUser,
    val createdAt: String,
    val gender: String,
    val health: String,
    val id: Int,
    val inoculation: String,
    val isComplete: Boolean,
    val isReceipt: Boolean,
    val name: String,
    val neutered: String,
    val photoUrls: List<PhotoUrl>,
    val pickUp: String,
    val receptionPeriod: String,
    val skill: String,
    val thumbnail: Thumbnail?,
    val user: User,
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

data class AddressInfo(
    val id: Int,
    val longName: String,
    val shortName: String
)

data class CompleteUser(
    val id: Int
)

data class PhotoUrl(
    val createdAt: String,
    val id: Int,
    val isDeleted: Boolean,
    val photoUrl: String
)

data class Thumbnail(
    val createdAt: String,
    val id: Int,
    val isDeleted: Boolean,
    val photoUrl: String
)

data class User(
    val id: Int
)