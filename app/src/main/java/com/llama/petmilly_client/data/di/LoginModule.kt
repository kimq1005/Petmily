package com.llama.petmilly_client.data.di

import com.llama.petmilly_client.data.repository.login.PostLoginUseCaseImpl
import com.llama.petmilly_client.domain.usecase.login.PostLoginUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginModule {
    abstract fun bindPostLoginUseCase(impl: PostLoginUseCaseImpl): PostLoginUseCase
}