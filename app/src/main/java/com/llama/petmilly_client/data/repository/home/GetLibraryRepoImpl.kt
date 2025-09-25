package com.llama.petmilly_client.data.repository.home

import com.llama.petmilly_client.data.model.LibraryDTO.toDomain
import com.llama.petmilly_client.data.network.LibraryApiService
import com.llama.petmilly_client.domain.model.home.Library
import com.llama.petmilly_client.domain.usecase.home.GetLibraryUseCase
import javax.inject.Inject

class GetLibraryRepoImpl @Inject constructor(
    private val libraryApiService: LibraryApiService,
) : GetLibraryUseCase {
    override suspend fun invoke(
        key: String,
        startIndex: Int,
        endIndex: Int,
    ): Result<Library> = runCatching {
        val data = libraryApiService.getLibrary(key, startIndex, endIndex).body()?.toDomain()
        data ?: throw NullPointerException()
    }
}