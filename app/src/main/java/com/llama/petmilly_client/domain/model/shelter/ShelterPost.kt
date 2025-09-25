package com.llama.petmilly_client.domain.model.shelter

data class Post(
    val success: Boolean,
    val data: PostData?
)

data class PostData(
    val limit: Int,
    val list: List<PostDetail>,
    val page: Int,
    val type: String,
)

data class PostDetail(
    val id: Int,
    val name: String,
    val age: Double,
    val breed: String,
    val gender: String,
    val inoculation: String,
    val isComplete: Boolean,
    val isReceipt: Boolean,
    val neutered: String,
    val thumbnail: ThumbnailDomain?,
    val weight: Int,
    val createdAt: String
)

data class ThumbnailDomain(
    val id: Int,
    val photoUrl: String,
    val createdAt: String,
    val isDeleted: Boolean
)