package com.llama.petmilly_client.data.repository.kakao

import android.content.Context
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.llama.petmilly_client.domain.usecase.login.KakaoLoginUseCase
import javax.inject.Inject

class KakaoLoginRepoImpl @Inject constructor(
) : KakaoLoginUseCase {
    override suspend fun invoke(
        context: Context,
    ): Result<Boolean> = runCatching {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (token != null && error != null) {
                //로그인성공
            } else {
                //로그인 실패
            }
        }

        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                if (error != null) {
                    //로그인 실패
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }

                    UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                } else {
                    //로그인 성공
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
        }

        true
    }
}