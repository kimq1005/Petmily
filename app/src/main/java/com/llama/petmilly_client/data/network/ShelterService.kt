package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.post.postdto.PostDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ShelterService {
    @GET("/post")
    suspend fun getPost(
        @Header("x-access-token") token: String,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("cat") cat: Boolean?,
        @Query("dog") dog: Boolean?,
        @Query("isComplete") isComplete: Boolean?,
        @Query("weight") weight: List<String>?,
        @Query("type") type: String,
    ): Response<PostDTO>
}