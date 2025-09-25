package com.llama.petmilly_client.data.di

import com.llama.petmilly_client.data.repository.shelter.GetShelterPostUseCaseImpl
import com.llama.petmilly_client.domain.usecase.shelter.GetShelterPostUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ShelterModule {
    @Binds
    abstract fun bindGetShelterPostUseCase(impl: GetShelterPostUseCaseImpl): GetShelterPostUseCase
}