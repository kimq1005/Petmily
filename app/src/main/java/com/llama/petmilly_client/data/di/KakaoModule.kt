package com.llama.petmilly_client.data.di

import com.llama.petmilly_client.data.repository.kakao.KakaoLoginRepoImpl
import com.llama.petmilly_client.domain.usecase.kakao.KakaoLoginUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class KakaoModule {
    @Binds
    abstract fun bindKakaoLoginUseCase(useCase: KakaoLoginRepoImpl): KakaoLoginUseCase
}