package com.llama.petmilly_client.presentation.shelter.items

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.data.model.post.postdto.PostData
import com.llama.petmilly_client.presentation.shelter.component.ShelterItemComponent

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShelterItem(
    modifier: Modifier = Modifier,
    postDataList: List<PostData>,
    onClick: (PostData) -> Unit,
) {
    LazyColumn(
        modifier = modifier
//            .padding(start = 7.dp, end = 7.dp)
    ) {

        items(postDataList) { items ->
            val convertAge: String = if (items.age > 1) {
                "${items.age.toInt()}살 추정"
            } else {
                val age = items.age * 10
                "$age 개월 추정"
            }
//            viewModel.id.value = items.id
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
//                        navController.navigate(ShelterSafeType.ANIMAL_INFO_DETAIL.name + "/${items.id}")
                })
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}