package com.llama.petmilly_client.data.repository.login

import com.llama.petmilly_client.data.TokenDataStore
import com.llama.petmilly_client.domain.usecase.login.GetTokenUseCase
import javax.inject.Inject

class GetTokenUseCaseImpl @Inject constructor(
    private val tokenDataStore: TokenDataStore,
) : GetTokenUseCase {
    override suspend fun invoke(): String? {
        return tokenDataStore.getToken()
    }
}