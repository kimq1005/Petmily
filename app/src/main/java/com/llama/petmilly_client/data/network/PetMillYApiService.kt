package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.TokenResponse
import com.llama.petmilly_client.data.model.accesstoken.AccessTokenDTO
import com.llama.petmilly_client.data.model.additonal.AdditionalSuccessDTO
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.findmypet.findmypetdetail.FindMyPetDetailDTO
import com.llama.petmilly_client.data.model.locationauthenticationResponse.LocationAuthenticationRequest
import com.llama.petmilly_client.data.model.moveservice.moveservicedetail.MoveServiceDetailDTO
import com.llama.petmilly_client.data.model.moveservice.patchmoveservicepost.patchmoveservicepostResponse
import com.llama.petmilly_client.data.model.moveservice.postmoveservice.MoveServicePostDTO
import com.llama.petmilly_client.data.model.shelter.PostDTO
import com.llama.petmilly_client.data.model.refreshtoken.RefreshTokenDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryProtectionDTO
import com.llama.petmilly_client.data.model.shelter.TemporaryDTO
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface PetMillYApiService {
    @POST("user/additional-info")
    suspend fun postAdditonalInfo(
        @Body additionalResponse: AdditionalResponse,
    ): Response<AdditionalSuccessDTO>

    @POST("user/reissuance-access-token")
    suspend fun postUserAccessToken(
        @Body tokenResponse: TokenResponse,
    ): Response<AccessTokenDTO>

    @POST("user/reissuance-refresh-token")
    suspend fun postUserRefreshToken(
        @Body tokenResponse: TokenResponse,
    ): Response<RefreshTokenDTO>

    @POST("post/temporary-protection")
    @Multipart
    @JvmSuppressWildcards
    suspend fun postTemporaryProtection(
        @Part files: List<MultipartBody.Part>?,
        @Part("charmAppeal") charmAppeal: String,
        @Part("animalTypes") animalTypes: String,
        @Part("name") name: String,
        @Part("gender") gender: String,
        @Part("weight") weight: String,
        @Part("breed") breed: String,
        @Part("age") age: String,
        @Part("neutered") neutered: String,
        @Part("inoculation") inoculation: String,
        @Part("health") health: String?,
        @Part("skill") skill: String?,
        @Part("character") character: String?,
        @Part("pickUp") pickUp: String,
        @Part("startReceptionPeriod") startReceptionPeriod: String?,
        @Part("endReceptionPeriod") endReceptionPeriod: String?,
        @Part("temporaryProtectionCondition") temporaryProtectionCondition: List<String>?,
        @Part("temporaryProtectionHope") temporaryProtectionHope: List<String>?,
        @Part("temporaryProtectionNo") temporaryProtectionNo: List<String>?,
    ): Response<TemporaryProtectionDTO>

    @POST("/user/town-auth")
    suspend fun postTownAuth(
        @Body locationAuthenticationResponse: LocationAuthenticationRequest,
    ): Response<TemporaryProtectionDTO>

    @GET("/post")
    suspend fun getPost(
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("cat") cat: Boolean?,
        @Query("dog") dog: Boolean?,
        @Query("isComplete") isComplete: Boolean?,
        @Query("weight") weight: List<String>?,
        @Query("type") type: String,
    ): Response<PostDTO>

    @GET("/post/temporary-protection/{id}")
    suspend fun getTemporaryDetail(
        @Path("id") id: Int,
    ): Response<TemporaryDTO>

    @POST("post/temporary-protection/{id}/photos")
    suspend fun postTemporaryPhoto(
        @Path("id") id: Int,
        @Part files: List<MultipartBody.Part>?,
    ): Response<TemporaryProtectionDTO>

    @PATCH("post/temporary-protection/{id}")
    suspend fun patchTemporary(
        @Path("id") id: Int,
    ): Response<TemporaryProtectionDTO>

    @DELETE("post/temporary-protection/{id}")
    suspend fun deleteTemporary(
        @Path("id") id: Int,
    ): Response<TemporaryProtectionDTO>

    @DELETE("/post/temporary-protection/{id}/photos/{photoId}")
    suspend fun deleteTemporaryPhoto(
        @Path("id") id: Int,
        @Path("photoId") photoId: Int,
    ): Response<TemporaryProtectionDTO>

    @POST("/post/move-volunteer")
    @Multipart
    @JvmSuppressWildcards
    suspend fun postMoveService(
        @Part("startAddress") startAddress: RequestBody,
        @Part("endAddress") endAddress: RequestBody,
        @Part("animalTypes") animalTypes: RequestBody,
        @Part("name") name: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("weight") weight: RequestBody,
        @Part("breed") breed: RequestBody,
        @Part("age") age: RequestBody,
        @Part("etc") etc: RequestBody,
        @Part("hopeDate") hopeDate: RequestBody,
        @Part files: List<MultipartBody.Part>?,
    ): Response<TemporaryProtectionDTO>


    @GET("/post")
    suspend fun getMoveService(
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("cat") cat: Boolean?,
        @Query("dog") dog: Boolean?,
        @Query("isComplete") isComplete: Boolean?,
        @Query("weight") weight: String?,
        @Query("type") type: String,
    ): Response<MoveServicePostDTO>

    @GET("/post/move-volunteer/{id}")
    suspend fun getMoveServicePostDetail(
        @Path("id") id: Int,
    ): Response<MoveServiceDetailDTO>

    @POST("/post/move-volunteer/{id}/photos")
    suspend fun postMoveServicePhoto(
        @Path("id") id: Int,
        @Part files: List<MultipartBody.Part>?,
    ): Response<TemporaryProtectionDTO>

    @PATCH("/post/move-volunteer/{id}")
    suspend fun patchMoveServicePost(
        @Path("id") id: Int,
        @Body patchMoveServicePostResponse: patchmoveservicepostResponse,
    ): Response<TemporaryProtectionDTO>

    @DELETE("post/move-volunteer/{id}")
    suspend fun deleteMoveServicePost(
        @Path("id") id: Int,
    ): Response<TemporaryProtectionDTO>

    @DELETE("post/move-volunteer/{id}/photos/{photoId}")
    suspend fun deleteMoveServicePhoto(
        @Path("id") id: Int,
        @Path("photoId") photoId: Int,
    ): Response<TemporaryProtectionDTO>

    @POST("/post/find-my-pet")
    @Multipart
    @JvmSuppressWildcards
    suspend fun postFindMyPet(
        @Part files: List<MultipartBody.Part>?,
        @Part("animalTypes") animalTypes: RequestBody,
        @Part("name") name: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("weight") weight: RequestBody,
        @Part("breed") breed: RequestBody,
        @Part("age") age: RequestBody,
        @Part("missingDate") missingDate: RequestBody,
        @Part("missingAddress") missingAddress: RequestBody,
        @Part("clothes") clothes: RequestBody?,
        @Part("lead") lead: RequestBody?,
        @Part("etc") etc: RequestBody?,
        @Part("isPublic") isPublic: RequestBody,
    ): Response<TemporaryProtectionDTO>


    //우리 아이 찾아요 게시글 댓글 작성
    @POST("/post/find-my-pet/{id}/comment")
    @Multipart
    @JvmSuppressWildcards
    suspend fun postFindMyPetComment(
        @Path("id") id: Int,
        @Part files: List<MultipartBody.Part>?,
        @Part("sightingAddress") sightingAddress: RequestBody,
        @Part("comment") comment: RequestBody,
        @Part("sightingDate") sightingDate: RequestBody,
    ): Response<TemporaryProtectionDTO>

    //우리 아이 찾아요 게시글 상세 조회
    @GET("post/find-my-pet/{id}")
    suspend fun getFindMyPetDetail(
        @Path("id") id: Int,
    ):Response<FindMyPetDetailDTO>


    //우리 아이 찾아요 댓글 삭제
    @DELETE("post/find-my-pet/{id}/comment/{commentId}")
    suspend fun deleteFindMyPetComment(
        @Path("id") id: Int,
        @Path("commentId") commentId: Int,
    ) : Response<TemporaryProtectionDTO>

    //우리 아이 찾아요 게시글 삭제
    @DELETE("post/find-my-pet/{id}")
    suspend fun deleteFindPetPost(
        @Path("id") id: Int,
    ) : Response<TemporaryProtectionDTO>
}