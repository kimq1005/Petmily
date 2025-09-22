package com.llama.petmilly_client.data.model.LibraryDTO

import com.google.gson.annotations.SerializedName

data class LibraryDTO(
   @SerializedName("SeoulPublicLibraryInfo") val libraryDTO: SeoulPublicLibraryInfoDTO
)

data class SeoulPublicLibraryInfoDTO(
    @SerializedName("RESULT") val result: ResultDTO,
    @SerializedName("list_total_count") val count: Int,
    @SerializedName("row") val clusterRow: List<LibraryDetailDTO>
)

data class ResultDTO(
    @SerializedName("CODE") val code: String,
    @SerializedName("MESSAGE") val message: String
)

data class LibraryDetailDTO(
    @SerializedName("ADRES") val address: String,
    @SerializedName("CODE_VALUE") val codeValue: String,
    @SerializedName("FDRM_CLOSE_DATE") val fdrmCloseDate: String,
    @SerializedName("GU_CODE") val guCode: String,
    @SerializedName("HMPG_URL") val hmpgUrl: String,
    @SerializedName("LBRRY_NAME") val libraryName: String,
    @SerializedName("LBRRY_SEQ_NO") val librarySeqNumber: String,
    @SerializedName("LBRRY_SE_NAME") val librarySeName: String,
    @SerializedName("OP_TIME") val opTime: String,
    @SerializedName("TEL_NO") val TelNumber: String,
    @SerializedName("XCNTS") val xCnts: String,
    @SerializedName("YDNTS") val yDnts: String
)