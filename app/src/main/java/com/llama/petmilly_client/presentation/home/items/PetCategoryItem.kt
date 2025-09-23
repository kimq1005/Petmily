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
import com.llama.petmilly_client.presentation.home.model.PetCategory

@Composable
fun PetCategoryItem(
    modifier: Modifier = Modifier,
    selectedPetCategory: List<PetCategory>,
    onClick: (PetCategory) -> Unit,
) {
    val petCategoryItem = PetCategory.values()

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(
            items = petCategoryItem,
            key = { i -> i.code }
        ) {
            CategoryComponent(
                modifier = Modifier
                    .padding(end = 8.dp),
                title = it.title,
                isSelected = selectedPetCategory.contains(it),
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
        selectedPetCategory = listOf(PetCategory.PUPPY, PetCategory.CAT),
        onClick = {}
    )
}