package com.llama.petmilly_client.presentation.home.model

import com.naver.maps.geometry.LatLng
import ted.gun0912.clustering.clustering.TedClusterItem
import ted.gun0912.clustering.geometry.TedLatLng

data class ClusterItem(
    val itemPosition: LatLng,
    val itemTitle: String,
    val itemSnippet: String,
) : TedClusterItem {
    override fun getTedLatLng(): TedLatLng {
        return TedLatLng(
            latitude = itemPosition.latitude,
            longitude = itemPosition.longitude
        )
    }
}