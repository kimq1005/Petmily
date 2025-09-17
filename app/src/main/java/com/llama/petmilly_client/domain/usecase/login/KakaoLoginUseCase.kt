package com.llama.petmilly_client.domain.usecase.login

import android.content.Context

interface KakaoLoginUseCase {
    suspend operator fun invoke(
        context: Context
    ) : Result<Boolean>
}