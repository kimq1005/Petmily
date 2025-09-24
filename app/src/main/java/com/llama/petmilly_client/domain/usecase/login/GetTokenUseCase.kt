package com.llama.petmilly_client.domain.usecase.login

interface GetTokenUseCase {
    suspend operator fun invoke(): String?
}