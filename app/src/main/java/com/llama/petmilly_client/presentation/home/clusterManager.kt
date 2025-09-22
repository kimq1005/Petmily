package com.llama.petmilly_client.presentation.home

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.llama.petmilly_client.R
import com.llama.petmilly_client.domain.model.home.LibraryDetail
import com.llama.petmilly_client.presentation.home.model.ClusterItem
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.NaverMap
import ted.gun0912.clustering.naver.TedNaverClustering

object ClusterManager {
    fun setClustering(
        context: Context,
        list: List<LibraryDetail>,
        naverMap: NaverMap,
        onCategoryClick: () -> Unit,
    ): TedNaverClustering<ClusterItem> {
        val items = mutableListOf<ClusterItem>()

        for (i in list) {
            val position = LatLng(i.xCnts.toDouble(), i.yDnts.toDouble())
            items.add(ClusterItem(position, i.address, i.codeValue))
        }

        Log.d("TAG", "setClustering: ${items.size}")
        val tedCluster = TedNaverClustering.with<ClusterItem>(context = context, naverMap)
            .items(items)
            .markerClickListener {

            }
            .clusterClickListener {
                onCategoryClick()
            }
        .customCluster {
            val clusterDesignText = ClusterDesignText()
            if (it.size >= 25) {
                clusterDesignText.cluster25(context, it.size, "매탄동")
            } else if (it.size >= 20) {
                clusterDesignText.cluster20(context, it.size, "원천동")
            } else if (it.size >= 15) {
                clusterDesignText.cluster15(context, it.size, "망포동")
            } else if (it.size >= 5) {
                clusterDesignText.cluster10(context, it.size, "인계동")
            } else {
                clusterDesignText.cluster5(context, it.size, "월계2동")
            }
        }
            .minClusterSize(0)
            .clusterAnimation(animate = true)
            .make()
        return tedCluster
    }

    class ClusterDesignText() {
        fun cluster25(context: Context, size: Int, location: String): TextView {
            return TextView(context).apply {
                this.background =
                    ContextCompat.getDrawable(context, R.drawable.background_clustering_25_oval)

                this.textSize = 30F
                this.width = 1200
                this.height = 1200
                this.gravity = Gravity.CENTER
                setTextColor(ContextCompat.getColor(context, R.color.black))
                val spannable = SpannableString("$location\n$size")
                val boldSpan = StyleSpan(Typeface.BOLD)
                spannable.setSpan(
                    boldSpan,
                    location.length + 1,
                    location.length + 1 + size.toString().length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                text = spannable
            }
        }

        fun cluster20(context: Context, size: Int, location: String): TextView {
            return TextView(context).apply {
                this.background =
                    ContextCompat.getDrawable(context, R.drawable.background_clustering_20_oval)
                this.textSize = 30F
                this.width = 1000
                this.height = 1000
                this.gravity = Gravity.CENTER
                setTextColor(ContextCompat.getColor(context, R.color.black))
                val spannable = SpannableString("$location\n$size")
                val boldSpan = StyleSpan(Typeface.BOLD)
                spannable.setSpan(
                    boldSpan,
                    location.length + 1,
                    location.length + 1 + size.toString().length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                text = spannable
            }
        }


        fun cluster15(context: Context, size: Int, location: String): TextView {
            return TextView(context).apply {
                this.background =
                    ContextCompat.getDrawable(context, R.drawable.background_clustering_15_oval)
                this.textSize = 30F
                this.width = 800
                this.height = 800
                this.gravity = Gravity.CENTER
                setTextColor(ContextCompat.getColor(context, R.color.black))
                val spannable = SpannableString("$location\n$size")
                val boldSpan = StyleSpan(Typeface.BOLD)
                spannable.setSpan(
                    boldSpan,
                    location.length + 1,
                    location.length + 1 + size.toString().length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                text = spannable
            }
        }


        fun cluster10(context: Context, size: Int, location: String): TextView {
            return TextView(context).apply {
                this.background =
                    ContextCompat.getDrawable(context, R.drawable.background_clustering_10_oval)
                this.textSize = 30F
                this.width = 700
                this.height = 700
                this.gravity = Gravity.CENTER
                setTextColor(ContextCompat.getColor(context, R.color.black))
                val spannable = SpannableString("$location\n$size")
                val boldSpan = StyleSpan(Typeface.BOLD)
                spannable.setSpan(
                    boldSpan,
                    location.length + 1,
                    location.length + 1 + size.toString().length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                text = spannable
            }
        }


        fun cluster5(context: Context, size: Int, location: String): TextView {
            return TextView(context).apply {
                this.background =
                    ContextCompat.getDrawable(context, R.drawable.background_clustering_5_oval)
                this.textSize = 30F
                this.width = 500
                this.height = 500
                this.gravity = Gravity.CENTER
                setTextColor(ContextCompat.getColor(context, R.color.black))
//            text = "${location}\n${size}"

                val spannable = SpannableString("$location\n$size")
                val boldSpan = StyleSpan(Typeface.BOLD)
                spannable.setSpan(
                    boldSpan,
                    location.length + 1,
                    location.length + 1 + size.toString().length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                text = spannable
            }
        }
    }
}