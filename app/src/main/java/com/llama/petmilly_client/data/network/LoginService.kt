package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("user/kakao-sign-in/")
    suspend fun postKakaoToken(
        @Body token: String,
    ): Response<KaKaoLoginDTO>
}