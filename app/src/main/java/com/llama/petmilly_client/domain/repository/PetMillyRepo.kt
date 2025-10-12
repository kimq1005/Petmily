package com.llama.petmilly_client.domain.repository

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
import com.llama.petmilly_client.utils.RemoteResult
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface PetMillyRepo {
    suspend fun postAdditonalInfo(
        additionalResponse: AdditionalResponse,
    ): RemoteResult<AdditionalSuccessDTO>

    suspend fun postUserAccessToken(
        tokenResponse: TokenResponse,
    ): RemoteResult<AccessTokenDTO>

    suspend fun postUserRefreshToken(
        tokenResponse: TokenResponse,
    ): RemoteResult<RefreshTokenDTO>

    suspend fun postTownAuth(
        locationAuthenticationResponse: LocationAuthenticationRequest,
    ): RemoteResult<TemporaryProtectionDTO>

    suspend fun getPost(
        page: Int?,
        limit: Int?,
        cat: Boolean?,
        dog: Boolean?,
        isComplete: Boolean?,
        weight: List<String>?,
        type: String,
    ): RemoteResult<PostDTO>


    suspend fun getTemporaryDetail(
        id: Int,
    ): RemoteResult<TemporaryDTO>

    suspend fun postTemporaryPhoto(
        id: Int,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryProtectionDTO>

    suspend fun patchTemporary(
        id: Int,
    ): RemoteResult<TemporaryProtectionDTO>

    suspend fun deleteTemporary(
        id: Int,
    ): RemoteResult<TemporaryProtectionDTO>

    suspend fun postMoveServicePost(
        startAddress: RequestBody,
        endAddress: RequestBody,
        animalTypes: RequestBody,
        name: RequestBody,
        gender: RequestBody,
        weight: RequestBody,
        breed: RequestBody,
        age: RequestBody,
        etc: RequestBody,
        hopeDate: RequestBody,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryProtectionDTO>

    suspend fun getMoveServicePost(
        page: Int?,
        limit: Int?,
        cat: Boolean?,
        dog: Boolean?,
        isComplete: Boolean?,
        weight: String?,
        type: String,
    ): RemoteResult<MoveServicePostDTO>


    suspend fun getMoveServicePostDetail(
        id: Int,
    ): RemoteResult<MoveServiceDetailDTO>

    suspend fun postMoveServicePhoto(
        id: Int,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryProtectionDTO>

    suspend fun patchMoveServicePost(
        id: Int,
        patchMoveServicePostResponse: patchmoveservicepostResponse,
    ): RemoteResult<TemporaryProtectionDTO>

    suspend fun deleteMoveServicePost(
        id: Int,
    ): RemoteResult<TemporaryProtectionDTO>

    suspend fun deleteMoveServicePhoto(
        id: Int,
        photoId: Int,
    ): RemoteResult<TemporaryProtectionDTO>

    suspend fun postFindMyPet(
        files: List<MultipartBody.Part>?,
        animalTypes: RequestBody,
        name: RequestBody,
        gender: RequestBody,
        weight: RequestBody,
        breed: RequestBody,
        age: RequestBody,
        missingDate: RequestBody,
        missingAddress: RequestBody,
        clothes: RequestBody?,
        lead: RequestBody?,
        etc: RequestBody?,
        isPublic: RequestBody,
    ): RemoteResult<TemporaryProtectionDTO>

    //우리 아이 찾아요 게시글 댓글 작성
    suspend fun postFindMyPetComment(
        id: Int,
        files: List<MultipartBody.Part>?,
        sightingAddress: RequestBody,
        comment: RequestBody,
        sightingDate: RequestBody,
    ): RemoteResult<TemporaryProtectionDTO>

    //우리 아이 찾아요 게시글 상세 조회
    suspend fun getFindMyPetDetail(
        id: Int,
    ): RemoteResult<FindMyPetDetailDTO>

    //우리 아이 찾아요 댓글 삭제
    suspend fun deleteFindMyPetComment(
        id: Int,
        commentId: Int,
    ): RemoteResult<TemporaryProtectionDTO>

    //우리 아이 찾아요 게시글 삭제
    suspend fun deleteFindPetPost(
        id: Int,
    ): RemoteResult<TemporaryProtectionDTO>
}