package com.llama.petmilly_client.presentation.shelterscreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import llama.test.jetpack_dagger_plz.utils.Common.TAG

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SafeShelterListScreen(
    navController: NavController,
    viewModel: ShelterViewModel,
) {
//    Scaffold {
//
//        val context = LocalContext.current
//
//        LaunchedEffect(context) {
//            viewModel.getpost()
//            viewModel.setsheltercategory()
//        }
//
//
//        Box(modifier = Modifier.fillMaxSize()) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//            ) {
//
//                LazyRow(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                ) {
//
//
//                    items(viewModel.shelterListCategory) { categorylist ->
//
//                        LibraryDetailDTO {
//                            if (viewModel.shelterListCategory.indexOf(categorylist) == 0) {
//                                Spacer(modifier = Modifier.padding(start = 15.dp))
//
//                                CategoryShelterItems(categorylist) { title, check ->
//                                    setpost(viewModel, title, check)
//
//                                }
//                            } else {
//                                CategoryShelterItems(ShelterListCategory = categorylist) { title, check ->
//                                    setpost(viewModel, title, check)
//                                }
//                            }
//
//                            Spacer(modifier = Modifier.width(6.dp))
//                        }
//
//
//                    }
//
//                }
//
//                Spacer(modifier = Modifier.height(10.dp))
//
////
//                LazyColumn(
//                    modifier = Modifier.padding(start = 7.dp, end = 7.dp)
//                ) {
//
//                    items(viewModel.postDataList) { items ->
//
//                        val convertage: String = if (items.age > 1) {
//                            "${items.age.toInt()}살 추정"
//                        } else {
//                            val age = items.age * 10
//                            "$age 개월 추정"
//                        }
//
//                        viewModel.id.value = items.id
//                        Column {
//                            ShelterCategoryItems(
//                                title = items.name,
//                                image = if (items.thumbnail != null) items.thumbnail.photoUrl else null,
//                                description = "${items.gender} / ${items.weight} / ${items.breed} / $convertage",
//                                vaccination = "${items.inoculation} /${items.neutered}",
//                                isComplete = items.isComplete,
//                                isReceipt = items.isReceipt,
//                                time = items.createdAt,
//                                onclcik = {
//                                    navController.navigate(ANIMALINFO_DETAIL + "/${items.id}")
//                                })
//                            Spacer(modifier = Modifier.height(6.dp))
//                        }
//                    }
//                }
//            }//column
//
//
//            Image(
//                painter = painterResource(id = R.drawable.img_write),
//                contentDescription = null,
//
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .padding(bottom = 40.dp, end = 15.dp)
//                    .width(55.dp)
//                    .height(55.dp)
//                    .clickable {
////                        val intent = Intent(context, ShelterDetailActivity::class.java)
////                        context.startActivity(intent)
//                        val intent = Intent(context, CertificationActivity::class.java)
//                        context.startActivity(intent)
//                    }
//            )
//
//        }//Box
//    }
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
    if(viewModel.categorylist.contains("~7kg") && !viewModel.weight.contains("small")){
        viewModel.weight.add("small")
    }

    if(viewModel.categorylist.contains("7~15kg")  && !viewModel.weight.contains("middle")){
        viewModel.weight.add("middle")
    }

    if(viewModel.categorylist.contains("15kg~") && !viewModel.weight.contains("big")){
        viewModel.weight.add("big")
    }


    viewModel.getpost()
}

