package com.llama.petmilly_client.data.repository.login

import com.llama.petmilly_client.data.TokenDataStore
import com.llama.petmilly_client.domain.usecase.login.SetTokenUseCase
import javax.inject.Inject

class SetTokenUseCaseImpl @Inject constructor(
    private val tokenDataStore: TokenDataStore,
) : SetTokenUseCase {
    override suspend fun invoke(token: String) {
        tokenDataStore.setToken(token)
    }
}