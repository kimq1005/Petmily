package com.llama.petmilly_client.presentation.login

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.llama.petmilly_client.R
import com.llama.petmilly_client.fcm.NotificationActivity
import com.llama.petmilly_client.presentation.MainViewModel
import com.llama.petmilly_client.presentation.homescreen.HomeActivity
import com.llama.petmilly_client.presentation.login.component.CustomDialog
import com.llama.petmilly_client.presentation.login.model.LoginSideEffect
import com.llama.petmilly_client.ui.theme.KaKao_BackgroundColor
import com.llama.petmilly_client.ui.theme.MainBackgroundColor
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun LoginSuccessScreen(
    viewModel: MainViewModel = hiltViewModel(),
) {
    val state = viewModel.collectAsState().value
    val context = LocalContext.current

    LoginScreen(
        onConfirm = viewModel::onConfirm,
        onDisConfirm = viewModel::onDisConfirm
    )

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is LoginSideEffect.Error -> {}
            is LoginSideEffect.NavigateToHomeActivity -> {
                val intent = Intent(context, HomeActivity::class.java)
                context.startActivity(intent)
            }

            is LoginSideEffect.NavigateToNotificationActivity -> {
                val intent = Intent(context, NotificationActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}

@Composable
fun LoginScreen(
    onConfirm: () -> Unit,
    onDisConfirm: () -> Unit,
) {
    var isDialogVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MainBackgroundColor)
            .padding(top = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.pet_milly_title),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        SpacerHeight(dp = 18.dp)

        Image(
            painter = painterResource(id = R.drawable.mainicon_png),
            contentDescription = null,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
        )

        SpacerHeight(dp = 18.dp)

        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.title_Description),
            fontSize = 13.sp,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, bottom = 70.dp)
                .height(60.dp)
                .background(color = KaKao_BackgroundColor, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .clickable { isDialogVisible = true },
        ) {
            Text(
                text = stringResource(id = R.string.kakao_login_text),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = notosans_bold,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
            )
        }

        if (isDialogVisible) {
            CustomDialog(
                onDismiss = {
                    isDialogVisible = false
                    onDisConfirm()
                },
                onConfirm = {
                    onConfirm()
                }
            )
        }
    }
}

fun kakaoLogin(context: Context, viewModel: MainViewModel) {
//    Log.d(TAG, "kakaoLogin: siba")
    viewModel.postkakaotoken()

//    val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
//        if (error != null) {
//            Log.d(TAG, "로그인 실패 -> $error ")
//            Toast.makeText(context, "카카오톡 로그인 실패", Toast.LENGTH_SHORT).show()
//        } else if (token != null) {
//            Log.d(TAG, "로그인 성공: ${token.accessToken}")
//            viewModel.postkakaotoken()
//
////            val intent = Intent(context, HomeActivity::class.java)
////            context.startActivity(intent)
//
//        }
//    }

//    if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
//        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
//            if (error != null) {
//                // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우
//                Log.d(TAG, "로그인 실패 두번째 -> $error")
//                if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
//                    return@loginWithKakaoTalk
//                }
//                // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
//                UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
//
//            } else if (token != null) {
//                MainApplication.kakaoaccesesstoken = token.accessToken
//                Log.d(TAG, "카카오 로그인 성공! 두번째 : ${MainApplication.kakaoaccesesstoken} ")
//                viewModel.postkakaotoken()
//
//
//                UserApiClient.instance.me { user, error ->
//                    if (error != null) {
//                        Log.d(TAG, "사용자 정보 요청 실패", error)
//                    } else if (user != null) {
//
//                    }
//                }
//
//            } else {
//                UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
//                Log.d(TAG, "넌 뭐니? : ")
//            }
//
//        }
//    }
}

@Preview
@Composable
private fun LoginPreview() {
    LoginScreen(
        onConfirm = {},
        onDisConfirm = {}
    )
}