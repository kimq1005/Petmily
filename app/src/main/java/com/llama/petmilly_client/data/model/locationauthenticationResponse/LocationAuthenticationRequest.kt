package com.llama.petmilly_client.data.model.locationauthenticationResponse

data class LocationAuthenticationRequest(
    val address: String,
)

fun LocationAuthenticationRequest.toRequest(): LocationAuthenticationRequest =
    LocationAuthenticationRequest(
        address = address
    )