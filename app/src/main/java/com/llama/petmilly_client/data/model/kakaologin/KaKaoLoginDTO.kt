package com.llama.petmilly_client.data.model.kakaologin

import com.llama.petmilly_client.domain.model.login.KaKAoLoginData
import com.llama.petmilly_client.domain.model.login.KaKaoLogin
import com.llama.petmilly_client.domain.model.login.LoginToken

data class KaKaoLoginDTO(
    val `data`: KaKaoLoginDataDTO,
    val isAccessTokenExpired: Boolean,
    val isRefreshTokenExpired: Boolean,
)

data class KaKaoLoginDataDTO(
    val isExistAdditionalInfo: Boolean,
    val tokenList: LoginTokenDTO,
)

data class LoginTokenDTO(
    val accessToken: String?,
    val refreshToken: String?
)

fun KaKaoLoginDTO.toDomain() = KaKaoLogin(
    data = this.data.toDomain(),
    isAccessTokenExpired = this.isAccessTokenExpired,
    isRefreshTokenExpired = this.isRefreshTokenExpired,
)

fun KaKaoLoginDataDTO.toDomain() = KaKAoLoginData(
    isExistAdditionalInfo = this.isExistAdditionalInfo,
    tokenList = this.tokenList.toDomain(),
)

fun LoginTokenDTO.toDomain() = LoginToken(
    accessToken = this.accessToken,
    refreshToken = this.refreshToken,
)