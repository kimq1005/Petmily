package com.llama.petmilly_client.domain.usecase.login

import com.llama.petmilly_client.domain.model.login.KaKaoLogin

interface PostLoginUseCase {
    suspend operator fun invoke(
        token: String
    ): Result<KaKaoLogin>
}