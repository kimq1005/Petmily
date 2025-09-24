package com.llama.petmilly_client.data.repository

import com.llama.petmilly_client.data.model.TokenResponse
import com.llama.petmilly_client.data.model.accesstoken.AccessTokenDTO
import com.llama.petmilly_client.data.model.additonal.AdditionalSuccessDTO
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.findmypet.findmypetdetail.FindMyPetDetailDTO
import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.data.model.locationauthenticationResponse.LocationauthenticationResponse
import com.llama.petmilly_client.data.model.moveservice.moveservicedetail.MoveServiceDetailDTO
import com.llama.petmilly_client.data.model.moveservice.patchmoveservicepost.patchmoveservicepostResponse
import com.llama.petmilly_client.data.model.moveservice.postmoveservice.MoveServicePostDTO
import com.llama.petmilly_client.data.model.post.postdto.PostDTO
import com.llama.petmilly_client.data.model.refreshtoken.RefreshTokenDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryprotectionDTO
import com.llama.petmilly_client.data.model.temporary.detail.TemporarydetailDTO
import com.llama.petmilly_client.data.network.PetMillYApiService
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import llama.test.jetpack_dagger_plz.utils.BaseDataSource
import com.llama.petmilly_client.utils.RemoteResult
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class PetMillyRepoImpl @Inject constructor(private val petMillYApiService: PetMillYApiService) :
    PetMillyRepo, BaseDataSource() {
    override suspend fun postadditonalinfo(
        additionalResponse: AdditionalResponse,
    ): RemoteResult<AdditionalSuccessDTO> = getResult {
        petMillYApiService.postadditonalinfo(additionalResponse)
    }

    override suspend fun postuseraccesstoken(
        tokenResponse: TokenResponse,
    ): RemoteResult<AccessTokenDTO> =
        getResult {
            petMillYApiService.postuseraccesstoken(tokenResponse)
        }

    override suspend fun postuserrefreshtoken(
        tokenResponse: TokenResponse,
    ): RemoteResult<RefreshTokenDTO> =
        getResult {
            petMillYApiService.postuserrefreshtoken(tokenResponse)
        }

    override suspend fun posttemporaryprotection(
        files: List<MultipartBody.Part>?,
        charmAppeal: RequestBody,
        animalTypes: RequestBody,
        name: RequestBody,
        gender: RequestBody,
        weight: RequestBody,
        breed: RequestBody,
        age: RequestBody,
        neutered: RequestBody,
        inoculation: RequestBody,
        health: RequestBody?,
        skill: RequestBody?,
        character: RequestBody?,
        pickUp: RequestBody,
        startReceptionPeriod: RequestBody?,
        endReceptionPeriod: RequestBody?,
        temporaryProtectionCondition: List<RequestBody>?,
        temporaryProtectionHope: List<RequestBody>?,
        temporaryProtectionNo: List<RequestBody>?, ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.posttemporaryprotection(
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

    override suspend fun posttownauth(
        locationauthenticationResponse: LocationauthenticationResponse,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.posttownauth(locationauthenticationResponse)
    }

    override suspend fun getpost(
        page: Int?,
        limit: Int?,
        cat: Boolean?,
        dog: Boolean?,
        isComplete: Boolean?,
        weight: List<String>?,
        type: String,
    ): RemoteResult<PostDTO> = getResult {
        petMillYApiService.getpost(page, limit, cat, dog, isComplete, weight, type)
    }


    override suspend fun gettemporarydetail(
        id: Int,
    ): RemoteResult<TemporarydetailDTO> = getResult {
        petMillYApiService.gettemporarydetail(id)
    }

    override suspend fun posttemporaryphoto(
        id: Int,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.posttemporaryphoto(id, files)
    }

    override suspend fun patchtemporary(
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.patchtemporary(id)
    }

    override suspend fun deletetemporary(
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.deletetemporary(id)
    }

    override suspend fun postmoveservicepost(
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
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.postmoveservicepost(
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

    override suspend fun getmoveservicepost(
        page: Int?,
        limit: Int?,
        cat: Boolean?,
        dog: Boolean?,
        isComplete: Boolean?,
        weight: String?,
        type: String,
    ): RemoteResult<MoveServicePostDTO> = getResult {
        petMillYApiService.getmoveservicepost(
            page,
            limit,
            cat,
            dog,
            isComplete,
            weight,
            type
        )
    }

    override suspend fun getmoveservicepostdetail(
        id: Int,
    ): RemoteResult<MoveServiceDetailDTO> = getResult {
        petMillYApiService.getmoveservicepostdetail(id)
    }

    override suspend fun postmoveservicephoto(
        id: Int,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.postmoveservicephoto(id, files)
    }

    override suspend fun patchmoveservicepost(
        id: Int,
        patchmoveservicepostResponse: patchmoveservicepostResponse,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.patchmoveservicepost(id, patchmoveservicepostResponse)
    }

    override suspend fun deletemoveservicepost(
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.deletemoveservicepost(id)
    }

    override suspend fun deletemoveservicephoto(
        id: Int,
        photoId: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.deletetemporaryphoto(id, photoId)
    }

    override suspend fun postfindmypet(
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
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.postfindmypet(
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

    override suspend fun postfindmypetcomment(
        id: Int,
        files: List<MultipartBody.Part>?,
        sightingAddress: RequestBody,
        comment: RequestBody,
        sightingDate: RequestBody,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.postfindmypetcomment(
            id,
            files,
            sightingAddress,
            comment,
            sightingDate
        )
    }

    override suspend fun getfindmypetdetail(
        id: Int,
    ): RemoteResult<FindMyPetDetailDTO> = getResult {
        petMillYApiService.getfindmypetdetail(id)
    }

    override suspend fun deletefindmypetcomment(
        id: Int,
        commentId: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.deletefindmypetcomment(id, commentId)
    }

    override suspend fun deletefindpetpost(
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.deletefindpetpost(id)
    }
}