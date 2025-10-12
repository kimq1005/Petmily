package com.llama.petmilly_client.data.di

import com.llama.petmilly_client.data.repository.shelter.GetShelterPostUseCaseImpl
import com.llama.petmilly_client.data.repository.shelter.GetTemporaryDetailUseCaseImpl
import com.llama.petmilly_client.data.repository.shelter.PostTemporaryProtectionUseCaseImpl
import com.llama.petmilly_client.domain.usecase.shelter.GetShelterPostUseCase
import com.llama.petmilly_client.domain.usecase.shelter.GetTemporaryDetailUseCase
import com.llama.petmilly_client.domain.usecase.shelter.PostTemporaryProtectionUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ShelterModule {
    @Binds
    abstract fun bindGetShelterPostUseCase(impl: GetShelterPostUseCaseImpl): GetShelterPostUseCase

    @Binds
    abstract fun bindGetTemporaryDetailUseCase(impl: GetTemporaryDetailUseCaseImpl): GetTemporaryDetailUseCase

    @Binds
    abstract fun bindPostTemporaryProtectionUseCase(impl: PostTemporaryProtectionUseCaseImpl): PostTemporaryProtectionUseCase
}