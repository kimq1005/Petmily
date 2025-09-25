package com.llama.petmilly_client.data.model.shelter

import com.google.gson.annotations.SerializedName
import com.llama.petmilly_client.domain.model.shelter.Post
import com.llama.petmilly_client.domain.model.shelter.PostData
import com.llama.petmilly_client.domain.model.shelter.PostDetail
import com.llama.petmilly_client.domain.model.shelter.ThumbnailDomain

data class PostDTO(
    @SerializedName("`data`") val postData: PostDataDTO?,
    @SerializedName("success") val success: Boolean,
)

data class PostDataDTO(
    @SerializedName("limit") val limit: Int,
    @SerializedName("list") val list: List<PostDataDetailDTO>,
    @SerializedName("page") val page: Int,
    @SerializedName("type") val type: String,
)

data class PostDataDetailDTO(
    @SerializedName("age") val age: Double,
    @SerializedName("breed") val breed: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("inoculation") val inoculation: String,
    @SerializedName("isComplete") val isComplete: Boolean,
    @SerializedName("isReceipt") val isReceipt: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("neutered") val neutered: String,
    @SerializedName("thumbnail") val thumbnail: ThumbnailDTO?,
    @SerializedName("weight") val weight: Int,
)

data class ThumbnailDTO(
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("id") val id: Int,
    @SerializedName("isDeleted") val isDeleted: Boolean,
    @SerializedName("photoUrl") val photoUrl: String,
)

fun PostDTO.toDomain(): Post =
    Post(
        success = success,
        data = postData?.toDomain()
    )

fun PostDataDTO.toDomain(): PostData =
    PostData(
        limit = limit,
        list = this.list.map { it.toDomain() },
        page = page,
        type = type
    )

fun PostDataDetailDTO.toDomain(): PostDetail =
    PostDetail(
        id = id,
        name = name,
        age = age,
        breed = breed,
        gender = gender,
        inoculation = inoculation,
        isComplete = isComplete,
        isReceipt = isReceipt,
        neutered = neutered,
        thumbnail = thumbnail?.toDomain(),
        weight = weight,
        createdAt = createdAt
    )

fun ThumbnailDTO.toDomain(): ThumbnailDomain =
    ThumbnailDomain(
        id = id,
        photoUrl = photoUrl,
        createdAt = createdAt,
        isDeleted = isDeleted
    )