package com.llama.petmilly_client.data.model.post.postdto

import com.google.gson.annotations.SerializedName

data class PostDTO(
    @SerializedName("`data`") val postData: PostData?,
    @SerializedName("success") val success: Boolean,
)

data class PostData(
    @SerializedName("limit") val limit: Int,
    @SerializedName("list") val list: List<PostDataDetail>,
    @SerializedName("page") val page: Int,
    @SerializedName("type") val type: String,
)

data class PostDataDetail(
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
    @SerializedName("thumbnail") val thumbnail: Thumbnail?,
    @SerializedName("weight") val weight: Int,
)

data class Thumbnail(
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("id") val id: Int,
    @SerializedName("isDeleted") val isDeleted: Boolean,
    @SerializedName("photoUrl") val photoUrl: String,
)