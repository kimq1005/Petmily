package com.llama.petmilly_client.presentation.shelterWrite

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.common.compnent.TitleBarComponent
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.notosans_bold
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun ShelterDetail_6_conditons_Screen(
    navController: NavController,
    viewModel: ShelterWriteViewModel,
    activity: Activity,
) {

    SetAlomostCompletedDialog(
        viewModel.isAlmostCompletedDialog, onDismiss = {
            viewModel.onDismissAlmostCompetedDialog()
        },
        activity = activity
    )

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TitleBarComponent(
            title = "임보처구해요",
            isMenu = false,
            onClickBack = { navController.popBackStack() },
            onClickMenu = { viewModel.onShownAlmostCompetedDialog() }
        )

        ShelterWriteSubTitleComponent("임보조건을\n입력해주세요.")

        Spacer(modifier = Modifier.height(28.dp))
        ///////////////////////////////////////

        Text(
            text = "\uD83D\uDC81\u200D 이런분을 희망해요",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            TextField(
                value = viewModel.hopepeople.value,
                onValueChange = { viewModel.hopepeople.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,

                    ),
                placeholder = { Text(text = "예) 출퇴근 유연하신 분") }
            )


            Image(
                painter = painterResource(id = R.drawable.img_test_dog4),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp)
                    .clickable {
                        if (viewModel.hopepeople.value != "") {
                            viewModel.addtemporaryProtectionHope(viewModel.hopepeople.value)
                            viewModel.hopepeople.value = ""
                        }
                    },
                contentScale = ContentScale.Crop
            )
        }//LibraryDetailDTO

        SpacerHeight(dp = 9.dp)

        LazyColumn(
            modifier = Modifier.padding(horizontal = 28.dp)
        ) {
            items(viewModel.temporaryProtectionHope) { item ->
                TemporaryProtectionCondition(true, item, ondelete = {
                    viewModel.deletetemporaryProtectionHope(item)
                })

                SpacerHeight(dp = 7.dp)

            }

        }



        Spacer(modifier = Modifier.height(90.dp))

        Text(
            text = "✋\u200D 이런분은 안돼요",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            TextField(
                value = viewModel.nopeople.value,
                onValueChange = { viewModel.nopeople.value = it },
                modifier = Modifier
                    .weight(8.5f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextField_BackgroudColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.Black,

                    ),
                placeholder = { Text(text = "예) 집을 비우는 시간이 너무 기신 분") }
            )


            Image(
                painter = painterResource(id = R.drawable.img_test_dog4),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp)
                    .clickable {
                        if (viewModel.nopeople.value != "") {
                            viewModel.addtemporaryProtectionNo(viewModel.nopeople.value)
                            viewModel.nopeople.value = ""
                        }
                    },
                contentScale = ContentScale.Crop
            )
        }//LibraryDetailDTO

        SpacerHeight(dp = 9.dp)

        LazyColumn(
            modifier = Modifier.padding(horizontal = 28.dp)
        ) {
            items(viewModel.temporaryProtectionNo) { item ->
                TemporaryProtectionCondition(false, item, ondelete = {
                    viewModel.deletetemporaryProtectionNo(item)
                })

                SpacerHeight(dp = 7.dp)

            }

        }


        ///////////////////////////////////////
        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {
            val ischeck =
                viewModel.temporaryProtectionHope.size > 0 && viewModel.temporaryProtectionNo.size > 0

            ButtonScreen(
                title = "다음",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = Color.Black

            ) {
                navController.navigate(Common.SHELTERDETAIL_7_CHARMAPPEAL_SCREEN)
            }

            Text(
                text = "6/8", fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
            )

        }
    }
}
