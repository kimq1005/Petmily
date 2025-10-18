package com.llama.petmilly_client.presentation.myProfile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.common.compnent.TitleBarComponent
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.SpacerWidth
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfileViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TitleBarComponent(title = "", isMenu = false, onClickBack = { }) {

        }

        Row(
            modifier = Modifier
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {

            SpacerWidth(dp = 29.dp)

            Image(
                painter = painterResource(id = R.drawable.img_test_puppy),
                contentDescription = null,
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Fit
            )
            SpacerWidth(dp = 16.dp)

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "llama",
                    fontSize = 20.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black
                )
                SpacerHeight(dp = 3.dp)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "동네인증", color = Color.Black,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 13.sp
                    )

                    SpacerWidth(dp = 5.dp)

                    Image(
                        painter = painterResource(id = R.drawable.img_checkcircle_green),
                        contentDescription = null,
                        modifier = Modifier
                            .height(18.dp)
                            .width(18.dp)
                    )

                }


            }

        }//LibraryDetailDTO

        SpacerHeight(dp = 20.dp)

        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Divider(modifier = Modifier.weight(2f), color = Color.Black)

            Box(
                modifier = Modifier
                    .weight(7f)
                    .height(62.dp)
                    .background(color = Color(0xFFECF2FF), shape = RoundedCornerShape(2.dp)),
            ) {
                CircleView(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = (-3).dp), color = Color.Black
                )

                Row(
                    Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "입양",
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                        Text(
                            text = "0건",
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                    }//Column

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "임보",
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                        Text(
                            text = "0건",
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                    }//Column

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "이동봉사",
                            fontFamily = notosans_bold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                        Text(
                            text = "0건",
                            fontFamily = notosans_regular,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            color = Color.Black,
                            fontSize = 13.sp
                        )

                    }//Column
                }

                Image(
                    painter = painterResource(id = R.drawable.img_test_dog4),
                    contentDescription = null,
                    modifier = Modifier
                        .height(15.dp)
                        .width(15.dp)
                        .align(Alignment.TopEnd)
                        .padding(top = 4.dp, end = 4.dp),
                    contentScale = ContentScale.Crop

                )

                CircleView(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = 3.dp), color = Color.Black
                )
            }

            Divider(modifier = Modifier.weight(2f), color = Color.Black)

        }//Row리
        
        SpacerHeight(dp = 20.dp)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 50.dp)
        ) {
            Text(
                text = "펫밀리", color = Color.Black, fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp
            )

            SpacerWidth(dp = 6.dp)

            Image(
                painter = painterResource(id = R.drawable.img_test_dog4),
                contentDescription = null,
                modifier = Modifier
                    .height(15.dp)
                    .width(15.dp)
                    .padding(top = 4.dp, end = 4.dp),
                contentScale = ContentScale.Crop

            )
        }//LibraryDetailDTO

        SpacerHeight(dp = 15.dp)


        BarGraph(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .requiredHeight(15.dp)
                .background(Color(0xFFFAEBFE), shape = RoundedCornerShape(13.dp)), percentage = 10f
        )

        SpacerHeight(dp = 20.dp)


        Column(
            Modifier
                .background(color = Color(0xFF80FDFCE1))
                .weight(1f)
        ) {

            SpacerHeight(dp = 16.dp)

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\uD83D\uDCCC 작성 게시물", fontFamily = notosans_bold, style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.img_go), contentDescription = null,
                    modifier = Modifier
                        .height(15.dp)
                        .width(15.dp)
                )


            }//LibraryDetailDTO

            SpacerHeight(dp = 40.dp)

            Text(
                text = "게시물이 아직 없어요",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp,
                color = Black_30_Transfer,
                textAlign = TextAlign.Center
            )


            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\uD83D\uDC8C 구조 이야기", fontFamily = notosans_bold, style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.img_go), contentDescription = null,
                    modifier = Modifier
                        .height(15.dp)
                        .width(15.dp)
                )


            }//LibraryDetailDTO

            SpacerHeight(dp = 40.dp)

            Text(
                text = "게시물이 아직 없어요",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp,
                color = Black_30_Transfer,
                textAlign = TextAlign.Center
            )



            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\uD83E\uDDB4 임보 스토리", fontFamily = notosans_bold, style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.img_go), contentDescription = null,
                    modifier = Modifier
                        .height(15.dp)
                        .width(15.dp)
                )


            }//LibraryDetailDTO

            SpacerHeight(dp = 40.dp)

            Text(
                text = "게시물이 아직 없어요",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 13.sp,
                color = Black_30_Transfer,
                textAlign = TextAlign.Center
            )


        }




    }//Column


}

@Preview
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()
    val viewModel: ProfileViewModel = hiltViewModel()

    ProfileScreen(navController, viewModel)
}

@Composable
fun CircleView(modifier: Modifier, color: Color) {
    Canvas(modifier = modifier.size(6.dp)) {
        drawCircle(color = color)
    }
}


@Composable
fun BarGraph(modifier: Modifier, percentage: Float) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(percentage / 100f)
                .background(Category_Cliked, shape = RoundedCornerShape(13.dp))
        )
    }
}


@Composable
fun Test() {
    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(100.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Blue)
        ) {
            // 두 번째 Column의 내용
            Text(text = "dasdasda")
        }
    }
}


@Preview
@Composable
fun ASDAD() {
    val navController = rememberNavController()
    val viewModel: ProfileViewModel = hiltViewModel()
    ProfileScreen(navController, viewModel)

}