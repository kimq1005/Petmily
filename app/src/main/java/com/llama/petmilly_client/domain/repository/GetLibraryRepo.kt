package com.llama.petmilly_client.domain.repository

import com.llama.petmilly_client.data.model.LibraryDTO.LibraryDTO
import com.llama.petmilly_client.utils.RemoteResult

interface GetLibraryRepo {

    suspend fun getLibrary(
        KEY: String,
        START_INDEX: Int,
        END_INDEX: Int,
    ): RemoteResult<LibraryDTO>
}