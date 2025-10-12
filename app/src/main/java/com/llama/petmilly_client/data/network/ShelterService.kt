package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.locationauthenticationResponse.LocationAuthenticationRequest
import com.llama.petmilly_client.data.model.shelter.PostDTO
import com.llama.petmilly_client.data.model.shelter.TemporaryDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryProtectionDTO
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeCategoryType
import com.llama.petmilly_client.presentation.shelterWrite.model.GenderType
import com.llama.petmilly_client.presentation.shelterWrite.model.NeuteringType
import com.llama.petmilly_client.presentation.shelterWrite.model.PickUpType
import com.llama.petmilly_client.presentation.shelterWrite.model.VaccinationType
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDateTime

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

    @POST("post/temporary-protection")
    @Multipart
    @JvmSuppressWildcards
    suspend fun postTemporaryProtection(
        @Part files: List<MultipartBody.Part>?,
        @Part("charmAppeal") charmAppeal: String,
        @Part("animalTypes") petCategoryType: PetCategoryType,
        @Part("name") name: String,
        @Part("gender") genderType: GenderType,
        @Part("weight") weight: String,
        @Part("breed") breed: String,
        @Part("age") age: String,
        @Part("neutered") neuteredType: NeuteringType,
        @Part("inoculation") vaccinationType: VaccinationType,
        @Part("health") health: String?,
        @Part("skill") skill: String?,
        @Part("character") character: String?,
        @Part("pickUp") pickUpType: PickUpType,
        @Part("startReceptionPeriod") startReceptionPeriod: LocalDateTime?,
        @Part("endReceptionPeriod") endReceptionPeriod: LocalDateTime?,
        @Part("temporaryProtectionCondition") temporaryProtectionCondition: List<String>?,
        @Part("temporaryProtectionHope") temporaryProtectionHope: List<String>?,
        @Part("temporaryProtectionNo") temporaryProtectionNo: List<String>?,
    ): Response<Boolean>
}