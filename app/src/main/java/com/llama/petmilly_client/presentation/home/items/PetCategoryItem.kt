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
import com.llama.petmilly_client.presentation.home.model.PetCategoryType

@Composable
fun PetCategoryItem(
    modifier: Modifier = Modifier,
    selectedPetCategoryType: List<PetCategoryType>,
    onClick: (PetCategoryType) -> Unit,
) {
    val petCategoryTypeItem = PetCategoryType.values()

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(
            items = petCategoryTypeItem,
            key = { i -> i.code }
        ) {
            CategoryComponent(
                modifier = Modifier
                    .padding(end = 8.dp),
                title = it.title,
                isSelected = selectedPetCategoryType.contains(it),
                onClick = {
                    onClick(it)
                }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewPetCategoryItem() {
    PetCategoryItem(
        modifier = Modifier
            .fillMaxWidth(),
        selectedPetCategoryType = listOf(PetCategoryType.PUPPY, PetCategoryType.CAT),
        onClick = {}
    )
}