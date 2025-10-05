package com.llama.petmilly_client.data.repository

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
import com.llama.petmilly_client.data.network.PetMillYApiService
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import llama.test.jetpack_dagger_plz.utils.BaseDataSource
import com.llama.petmilly_client.utils.RemoteResult
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class PetMillyRepoImpl @Inject constructor(private val petMillYApiService: PetMillYApiService) :
    PetMillyRepo, BaseDataSource() {
    override suspend fun postAdditonalInfo(
        additionalResponse: AdditionalResponse,
    ): RemoteResult<AdditionalSuccessDTO> = getResult {
        petMillYApiService.postAdditonalInfo(additionalResponse)
    }

    override suspend fun postUserAccessToken(
        tokenResponse: TokenResponse,
    ): RemoteResult<AccessTokenDTO> =
        getResult {
            petMillYApiService.postUserAccessToken(tokenResponse)
        }

    override suspend fun postUserRefreshToken(
        tokenResponse: TokenResponse,
    ): RemoteResult<RefreshTokenDTO> =
        getResult {
            petMillYApiService.postUserRefreshToken(tokenResponse)
        }

    override suspend fun postTemporaryProtection(
        files: List<MultipartBody.Part>?,
        charmAppeal: String,
        animalTypes: String,
        name: String,
        gender: String,
        weight: String,
        breed: String,
        age: String,
        neutered: String,
        inoculation: String,
        health: String?,
        skill: String?,
        character: String?,
        pickUp: String,
        startReceptionPeriod: String?,
        endReceptionPeriod: String?,
        temporaryProtectionCondition: List<String>?,
        temporaryProtectionHope: List<String>?,
        temporaryProtectionNo: List<String>?,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.postTemporaryProtection(
            files,
            charmAppeal,
            animalTypes,
            name,
            gender,
            weight,
            breed,
            age,
            neutered,
            inoculation,
            health,
            skill,
            character,
            pickUp,
            startReceptionPeriod,
            endReceptionPeriod,
            temporaryProtectionCondition,
            temporaryProtectionHope,
            temporaryProtectionNo
        )
    }

    override suspend fun postTownAuth(
        locationAuthenticationResponse: LocationAuthenticationRequest,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.postTownAuth(locationAuthenticationResponse)
    }

    override suspend fun getPost(
        page: Int?,
        limit: Int?,
        cat: Boolean?,
        dog: Boolean?,
        isComplete: Boolean?,
        weight: List<String>?,
        type: String,
    ): RemoteResult<PostDTO> = getResult {
        petMillYApiService.getPost(page, limit, cat, dog, isComplete, weight, type)
    }


    override suspend fun getTemporaryDetail(
        id: Int,
    ): RemoteResult<TemporaryDTO> = getResult {
        petMillYApiService.getTemporaryDetail(id)
    }

    override suspend fun postTemporaryPhoto(
        id: Int,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.postTemporaryPhoto(id, files)
    }

    override suspend fun patchTemporary(
        id: Int,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.patchTemporary(id)
    }

    override suspend fun deleteTemporary(
        id: Int,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.deleteTemporary(id)
    }

    override suspend fun postMoveServicePost(
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
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.postMoveService(
            startAddress,
            endAddress,
            animalTypes,
            name,
            gender,
            weight,
            breed,
            age,
            etc,
            hopeDate,
            files
        )
    }

    override suspend fun getMoveServicePost(
        page: Int?,
        limit: Int?,
        cat: Boolean?,
        dog: Boolean?,
        isComplete: Boolean?,
        weight: String?,
        type: String,
    ): RemoteResult<MoveServicePostDTO> = getResult {
        petMillYApiService.getMoveService(
            page,
            limit,
            cat,
            dog,
            isComplete,
            weight,
            type
        )
    }

    override suspend fun getMoveServicePostDetail(
        id: Int,
    ): RemoteResult<MoveServiceDetailDTO> = getResult {
        petMillYApiService.getMoveServicePostDetail(id)
    }

    override suspend fun postMoveServicePhoto(
        id: Int,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.postMoveServicePhoto(id, files)
    }

    override suspend fun patchMoveServicePost(
        id: Int,
        patchMoveServicePostResponse: patchmoveservicepostResponse,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.patchMoveServicePost(id, patchMoveServicePostResponse)
    }

    override suspend fun deleteMoveServicePost(
        id: Int,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.deleteMoveServicePost(id)
    }

    override suspend fun deleteMoveServicePhoto(
        id: Int,
        photoId: Int,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.deleteTemporaryPhoto(id, photoId)
    }

    override suspend fun postFindMyPet(
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
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.postFindMyPet(
            files,
            animalTypes,
            name,
            gender,
            weight,
            breed,
            age,
            missingDate,
            missingAddress,
            clothes,
            lead,
            etc,
            isPublic
        )
    }

    override suspend fun postFindMyPetComment(
        id: Int,
        files: List<MultipartBody.Part>?,
        sightingAddress: RequestBody,
        comment: RequestBody,
        sightingDate: RequestBody,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.postFindMyPetComment(
            id,
            files,
            sightingAddress,
            comment,
            sightingDate
        )
    }

    override suspend fun getFindMyPetDetail(
        id: Int,
    ): RemoteResult<FindMyPetDetailDTO> = getResult {
        petMillYApiService.getFindMyPetDetail(id)
    }

    override suspend fun deleteFindMyPetComment(
        id: Int,
        commentId: Int,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.deleteFindMyPetComment(id, commentId)
    }

    override suspend fun deleteFindPetPost(
        id: Int,
    ): RemoteResult<TemporaryProtectionDTO> = getResult {
        petMillYApiService.deleteFindPetPost(id)
    }
}