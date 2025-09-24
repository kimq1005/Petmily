package com.llama.petmilly_client.domain.usecase.login

interface SetTokenUseCase {
    suspend operator fun invoke(token: String)
}