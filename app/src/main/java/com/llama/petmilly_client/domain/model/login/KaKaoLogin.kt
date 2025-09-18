package com.llama.petmilly_client.domain.model.login

data class KaKaoLogin(
    val `data`: KaKAoLoginData,
    val isAccessTokenExpired: Boolean,
    val isRefreshTokenExpired: Boolean
)

data class KaKAoLoginData(
    val isExistAdditionalInfo: Boolean,
    val tokenList: LoginToken
)

data class LoginToken(
    val accessToken: String?,
    val refreshToken: String?
)