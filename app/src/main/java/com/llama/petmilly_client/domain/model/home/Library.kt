package com.llama.petmilly_client.domain.model.home

data class Library(
    val libraryDTO: SeoulPublicLibraryInfo,
)

data class SeoulPublicLibraryInfo(
    val result: LibraryResult,
    val count: Int,
    val clusterRow: List<LibraryDetail>,
)

data class LibraryResult(
    val code: String,
    val message: String,
)

data class LibraryDetail(
    val address: String,
    val codeValue: String,
    val fdrmCloseDate: String,
    val guCode: String,
    val hmpgUrl: String,
    val libraryName: String,
    val librarySeqNumber: String,
    val librarySeName: String,
    val opTime: String,
    val TelNumber: String,
    val xCnts: String,
    val yDnts: String,
)