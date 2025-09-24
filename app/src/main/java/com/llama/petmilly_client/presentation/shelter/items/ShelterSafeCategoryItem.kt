package com.llama.petmilly_client.presentation.shelter.items

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.presentation.home.component.CategoryComponent
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeCategoryType

@Composable
fun ShelterSafeCategoryItem(
    modifier: Modifier = Modifier,
    selectedItem: List<ShelterSafeCategoryType>,
    onClick: (ShelterSafeCategoryType) -> Unit,
) {
    val shelterCategoryItem = ShelterSafeCategoryType.values()

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
                isSelected = selectedItem.contains(it),
                onClick = {
                    onClick(it)
                }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewShelterSafeCategoryItem() {
    ShelterSafeCategoryItem(
        modifier = Modifier
            .fillMaxWidth(),
        selectedItem = listOf(ShelterSafeCategoryType.CAT, ShelterSafeCategoryType.SMALL),
        onClick = {}
    )
}