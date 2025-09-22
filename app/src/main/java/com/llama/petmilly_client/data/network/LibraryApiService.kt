package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.LibraryDTO.LibraryDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LibraryApiService {
    @GET("{KEY}/json/SeoulPublicLibraryInfo/{START_INDEX}/{END_INDEX}/")
    suspend fun getLibrary(
        @Path("KEY") key: String,
        @Path("START_INDEX") startIndex: Int,
        @Path("END_INDEX") endIndex: Int,
    ): Response<LibraryDTO>
}