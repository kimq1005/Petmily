package com.llama.petmilly_client.presentation.home.items

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.presentation.home.component.CategoryComponent
import com.llama.petmilly_client.presentation.home.model.ShelterCategory

@Composable
fun ShelterCategoryItem(
    modifier: Modifier = Modifier,
    selectedShelterCategory: List<ShelterCategory>,
    onClick: (ShelterCategory) -> Unit,
) {
    val shelterCategoryItem = ShelterCategory.values()

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(
            items = shelterCategoryItem,
            key = { i -> i.code }
        ) {
            CategoryComponent(
                modifier = Modifier
                    .padding(end = 8.dp),
                title = it.title,
                isSelected = selectedShelterCategory.contains(it),
                onClick = {
                    onClick(it)
                }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewShelterCategoryItem() {
    ShelterCategoryItem(
        modifier = Modifier
            .fillMaxWidth(),
        selectedShelterCategory = listOf(ShelterCategory.SAVE_SHELTER, ShelterCategory.FIND_MY_BABY),
        onClick = {}
    )
}