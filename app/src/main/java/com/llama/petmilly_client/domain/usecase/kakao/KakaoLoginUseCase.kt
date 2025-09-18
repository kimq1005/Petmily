package com.llama.petmilly_client.domain.usecase.kakao

import android.content.Context
import com.kakao.sdk.auth.model.OAuthToken

interface KakaoLoginUseCase {
    suspend operator fun invoke(
        context: Context
    ) : Result<OAuthToken>
}