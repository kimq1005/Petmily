package com.llama.petmilly_client.data.di

import com.llama.petmilly_client.data.repository.login.GetTokenUseCaseImpl
import com.llama.petmilly_client.data.repository.login.PostLoginUseCaseImpl
import com.llama.petmilly_client.data.repository.login.SetTokenUseCaseImpl
import com.llama.petmilly_client.domain.usecase.login.GetTokenUseCase
import com.llama.petmilly_client.domain.usecase.login.PostLoginUseCase
import com.llama.petmilly_client.domain.usecase.login.SetTokenUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginModule {

    @Binds
    abstract fun bindPostLoginUseCase(impl: PostLoginUseCaseImpl): PostLoginUseCase

    @Binds
    abstract fun bindSetTokenUseCase(impl: SetTokenUseCaseImpl): SetTokenUseCase

    @Binds
    abstract fun bindGetTokenUseCase(impl: GetTokenUseCaseImpl): GetTokenUseCase
}