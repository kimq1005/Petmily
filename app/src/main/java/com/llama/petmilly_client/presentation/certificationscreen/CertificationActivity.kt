package com.llama.petmilly_client.presentation.certificationscreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.common.compnent.TitleBarComponent
import com.llama.petmilly_client.presentation.shelterWrite.ShelterWriteActivity
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.SpacerHeight
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common.LOCATION_AUTHENTICATION_SCREEN

private var mynavermap: NaverMap? = null

@AndroidEntryPoint
class CertificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                val navController = rememberNavController()
                val viewModel: CertificationViewModel = hiltViewModel()

                NavHost(
                    navController = navController,
                    startDestination = LOCATION_AUTHENTICATION_SCREEN
                ) {
                    composable(route = LOCATION_AUTHENTICATION_SCREEN) {
//                        LocationauthenticationScreen(
//                            navController,
//                            viewModel,
//                            this@CertificationActivity
//                        )
                    }
                }
            }


        }
    }
}


@ExperimentalNaverMapApi
@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun LocationauthenticationScreen(
    navController: NavController,
    viewModel: CertificationViewModel,
    activity: Activity,
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    Column(Modifier.fillMaxSize()) {
        TitleBarComponent(
            title = "동네 인증",
            isMenu = false,
            onClickBack = {
                activity.finish()
            },
            onClickMenu = {}
        )
//
        Box(
            modifier = Modifier
                .weight(15f)
                .padding(top = 10.dp)
        ) {
//            CertificationNaverMap(viewModel)
        }

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "동네인증완료",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 50.dp),
            backgroundcolor = Color.Black
        ) {
//            viewModel.posttownauth()
            val intent = Intent(context, ShelterWriteActivity::class.java)
            context.startActivity(intent)
            activity.finish()
        }

        SpacerHeight(dp = 100.dp)
    }

    LaunchedEffect(context) {
//        setObserve(viewModel, context, lifecycleOwner, activity)
    }
}

//@Composable
//fun CertificationNaverMap(viewModel: CertificationViewModel) {
//    val map = naverMapComposable()
//    val context = LocalContext.current
//    val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
//    Box {
//        AndroidView(
//            factory = { map },
//            update = { mapview ->
//                mapview.getMapAsync { navermap ->
//                    mynavermap = navermap
//                    val marker = Marker()
//
//                    // 위치 정보 권한 요청 시작 할때로 바꾸기
//                    val permissionRequestCode = 123
//                    if (ActivityCompat.checkSelfPermission(
//                            context,
//                            Manifest.permission.ACCESS_FINE_LOCATION
//                        ) != PackageManager.PERMISSION_GRANTED
//                    ) {
//                        ActivityCompat.requestPermissions(
//                            context as Activity,
//                            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
//                            permissionRequestCode
//                        )
//                    } else {
//                        fusedLocationProviderClient.lastLocation
//                            .addOnSuccessListener { location ->
//                                // 위치 정보를 성공적으로 받아왔을 때 처리
//
//                                val mypostion =
//                                    LatLng(location.latitude, location.longitude) ?: LatLng(
//                                        37.715,
//                                        126.734
//                                    )
//
//                                getAddress(
//                                    context,
//                                    location.latitude,
//                                    location.longitude,
//                                    viewModel
//                                )
//                                marker.apply {
//                                    position = mypostion
//                                    icon = OverlayImage.fromResource(R.drawable.ic_navermarker)
//                                    width = 150
//                                    height = 180
//                                }
//
//                                marker.map = navermap
//                                val cameraUpdate = CameraUpdate.scrollTo(mypostion)
//                                navermap.moveCamera(cameraUpdate)
//                            }
//                            .addOnFailureListener { exception ->
//
//                                Log.d(TAG, "CertificationNaverMap2: $exception")
//
//                            }
//                    }
//                }
//            }
//        )
//    }
//}
//
//private fun getAddress(
//    context: Context,
//    latitude: Double,
//    longitude: Double,
//    viewModel: CertificationViewModel,
//): String {
//    val geoCoder = Geocoder(context, Locale.KOREA)
//    var address = ArrayList<Address>()
//    var addressResult = "주소를 가져 올 수 없습니다."
//    try {
//        address = geoCoder.getFromLocation(latitude, longitude, 1) as ArrayList<Address>
//        if (address.size > 0) {
//            val currentLocationAddress = address[0].getAddressLine(0).toString()
//            addressResult = currentLocationAddress
//            viewModel.townadress.value = addressResult
//            Log.d(TAG, "getAddress: $addressResult")
//        }
//    } catch (e: java.lang.Exception) {
//        Log.d(TAG, "getAddress ERROR: $e")
//        Toast.makeText(context, "주소를 불러올 수 없습니다. $e", Toast.LENGTH_SHORT).show()
//    }
//
//    return addressResult
//}

//private fun setObserve(
//    viewModel: CertificationViewModel,
//    context: Context,
//    lifecycleOwner: LifecycleOwner,
//    activity: Activity,
//) {
//    viewModel.setshelterIntent.observe(lifecycleOwner, androidx.lifecycle.Observer {
//        val intent = Intent(context, ShelterWriteActivity::class.java)
//        context.startActivity(intent)
//        activity.finish()
//    })
//}



