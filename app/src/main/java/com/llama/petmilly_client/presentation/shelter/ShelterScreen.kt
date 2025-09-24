package com.llama.petmilly_client.presentation.shelter

import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.certificationscreen.CertificationActivity
import com.llama.petmilly_client.presentation.shelter.items.ShelterItem
import com.llama.petmilly_client.presentation.shelter.items.ShelterSafeCategoryItem
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeType
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@Composable
fun SafeShelterSuccessScreen(
    viewModel: ShelterViewModel = hiltViewModel(),
) {

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SafeShelterScreen(
    navController: NavController,
    viewModel: ShelterViewModel,
) {
    val context = LocalContext.current

    LaunchedEffect(context) {
        viewModel.getpost()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ShelterSafeCategoryItem(
                selectedItem = emptyList(),
                onClick = {}
            )

            Spacer(modifier = Modifier.height(10.dp))

            ShelterItem(
                modifier = Modifier
                    .padding(horizontal = 7.dp),
                postDataList = viewModel.postDataList,
                onClick = {
                    navController.navigate(ShelterSafeType.ANIMAL_INFO_DETAIL.name + "/${it.id}")
                }
            )
        }

        Image(
            painter = painterResource(id = R.drawable.img_test_puppy),
            contentDescription = null,

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 40.dp, end = 15.dp)
                .size(55.dp)
                .clickable {
                    val intent = Intent(context, CertificationActivity::class.java)
                    context.startActivity(intent)
                }
        )
    }
}


//아니면 리스트를 만들어서 리스트에 해당하는 것만 호출?
private fun setpost(viewModel: ShelterViewModel, categorytitle: String, check: Boolean) {

    if (check) {
        viewModel.addcategorylist(categorytitle)
    } else {
        viewModel.deletecategorylist(categorytitle)
    }

    Log.d(TAG, "setpost: ${viewModel.categorylist}")
    viewModel.dog.value = viewModel.categorylist.contains("강아지")
    viewModel.cat.value = viewModel.categorylist.contains("고양이")
    viewModel.isComplete.value = !viewModel.categorylist.contains("petmily ❤️")
    viewModel.weight.clear()
    if (viewModel.categorylist.contains("~7kg") && !viewModel.weight.contains("small")) {
        viewModel.weight.add("small")
    }

    if (viewModel.categorylist.contains("7~15kg") && !viewModel.weight.contains("middle")) {
        viewModel.weight.add("middle")
    }

    if (viewModel.categorylist.contains("15kg~") && !viewModel.weight.contains("big")) {
        viewModel.weight.add("big")
    }


    viewModel.getpost()
}

