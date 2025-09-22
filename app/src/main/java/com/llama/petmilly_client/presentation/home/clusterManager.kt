package com.llama.petmilly_client.presentation.home

import android.content.Context
import com.llama.petmilly_client.data.model.LibraryDTO.LibraryDetailDTO
import com.llama.petmilly_client.presentation.home.model.ClusterItem
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.NaverMap
import ted.gun0912.clustering.naver.TedNaverClustering

object ClusterManager {
    fun setClustering(
        context: Context,
        list: List<LibraryDetailDTO>,
        naverMap: NaverMap,
        onCategoryClick: () -> Unit,
        categoryTitle: String,
//        viewModel: HomeViewModel,
    ): TedNaverClustering<ClusterItem> {
//        tedNaverClustering?.clearItems()
        val items = mutableListOf<ClusterItem>()

        for (i in list) {
            val position = LatLng(i.xCnts.toDouble(), i.yDnts.toDouble())
            items.add(ClusterItem(position, i.address, i.codeValue))
        }

        val tedCluster = TedNaverClustering.with<ClusterItem>(context = context, naverMap)
            .items(items)
            .clusterText {
                "안녕"
            }
            .markerClickListener {

            }
            .clusterClickListener {
                onCategoryClick()
            }
//        .customCluster {
//            val clusterDesginText = ClusterDesginText()
//            if (it.size >= 25) {
//                clusterDesginText.cluster25(context, it.size, "매탄동")
//            } else if (it.size >= 20) {
//                clusterDesginText.cluster20(context, it.size, "원천동")
//            } else if (it.size >= 15) {
//                clusterDesginText.cluster15(context, it.size, "망포동")
//            } else if (it.size >= 5) {
//                clusterDesginText.cluster10(context, it.size, "인계동")
//            } else {
//                clusterDesginText.cluster5(context, it.size, "월계2동")
//            }
//        }
            .minClusterSize(0)
            .clusterAnimation(animate = true)
            .make()
        return tedCluster
    }
}