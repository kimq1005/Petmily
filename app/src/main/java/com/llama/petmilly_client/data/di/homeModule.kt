package com.llama.petmilly_client.data.di

import com.llama.petmilly_client.data.repository.home.GetLibraryRepoImpl
import com.llama.petmilly_client.domain.usecase.home.GetLibraryUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {
    @Binds
    abstract fun bindGetLibraryUseCase(impl: GetLibraryRepoImpl): GetLibraryUseCase
}