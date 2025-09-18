package com.llama.petmilly_client.data.repository.login

import com.llama.petmilly_client.data.model.kakaologin.toDomain
import com.llama.petmilly_client.data.network.LoginService
import com.llama.petmilly_client.domain.model.login.KaKaoLogin
import com.llama.petmilly_client.domain.usecase.login.PostLoginUseCase
import javax.inject.Inject

class PostLoginUseCaseImpl @Inject constructor(
    private val loginService: LoginService,
) : PostLoginUseCase {
    override suspend fun invoke(
        token: String,
    ): Result<KaKaoLogin> = runCatching {
        val response = loginService.postKakaoToken(token)
        if (response.isSuccessful) {
            val body = response.body()
            body?.toDomain() ?: throw Exception("ResponseError")
        } else {
            throw Exception("ResponseError")
        }
    }
}