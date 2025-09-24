package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.TokenDataStore
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class PetMilyInterceptor @Inject constructor(
    private val tokenDataStore: TokenDataStore,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking {
            tokenDataStore.getToken()
        }

        return chain.proceed(
            request = chain.request()
                .newBuilder()
                .run {
                    if (token.isNullOrEmpty()) {
                        this
                    } else {
                        this.addHeader("x-access-token", token)
                    }
                }
                .build()
        )
    }
}