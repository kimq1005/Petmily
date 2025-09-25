package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.locationauthenticationResponse.LocationAuthenticationRequest
import com.llama.petmilly_client.data.model.shelter.PostDTO
import com.llama.petmilly_client.data.model.shelter.TemporaryDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryProtectionDTO
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeCategoryType
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ShelterService {
    @GET("/post")
    suspend fun getShelterPost(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("cat") cat: Boolean,
        @Query("dog") dog: Boolean,
        @Query("isComplete") isComplete: Boolean,
        @Query("weight") weight: List<ShelterSafeCategoryType>,
        @Query("type") type: String,
    ): Response<PostDTO>

    @POST("/user/town-auth")
    suspend fun postTownAuth(
        @Body locationAuthenticationResponse: LocationAuthenticationRequest,
    ): Response<TemporaryProtectionDTO>

    @GET("/post/temporary-protection/{id}")
    suspend fun getTemporaryDetail(
        @Path("id") id: Int,
    ): Response<TemporaryDTO>
}