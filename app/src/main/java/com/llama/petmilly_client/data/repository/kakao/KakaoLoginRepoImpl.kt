package com.llama.petmilly_client.data.repository.kakao

import android.content.Context
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.llama.petmilly_client.domain.usecase.kakao.KakaoLoginUseCase
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class KakaoLoginRepoImpl @Inject constructor() : KakaoLoginUseCase {
    override suspend fun invoke(
        context: Context,
    ): Result<OAuthToken> = suspendCoroutine { cont ->
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            when {
                token != null -> cont.resume(Result.success(token))
                error != null -> cont.resume(Result.failure(error))
                else -> cont.resume(Result.failure(Exception()))
            }
        }

        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                when {
                    error is ClientError && error.reason == ClientErrorCause.Cancelled -> cont.resume(Result.failure(error))
                    token != null -> cont.resume(Result.success(token))
                    else -> cont.resume(Result.failure(Exception("Unknown error")))
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
        }
    }
}