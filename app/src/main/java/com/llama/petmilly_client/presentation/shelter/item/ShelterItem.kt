package com.llama.petmilly_client.presentation.shelter.item

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.domain.model.shelter.PostDetail
import com.llama.petmilly_client.presentation.shelter.component.ShelterItemComponent

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShelterItem(
    modifier: Modifier = Modifier,
    postDataList: List<PostDetail>,
    onClick: (PostDetail) -> Unit,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(postDataList) { items ->
            val convertAge: String = if (items.age > 1) {
                "${items.age.toInt()}살 추정"
            } else {
                val age = items.age * 10
                "$age 개월 추정"
            }

            ShelterItemComponent(
                title = items.name,
                image = if (items.thumbnail != null) items.thumbnail.photoUrl else "",
                description = "${items.gender} / ${items.weight} / ${items.breed} / $convertAge",
                vaccination = "${items.inoculation} /${items.neutered}",
                isComplete = items.isComplete,
                isReceipt = items.isReceipt,
                time = items.createdAt,
                onClick = {
                    onClick(items)
                })
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}