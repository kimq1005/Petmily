package com.llama.petmilly_client.presentation.shelter

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.common.compnent.TitleBarComponent
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeType
import com.llama.petmilly_client.utils.notosans_bold
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShelterActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                val navController = rememberNavController()

                Column {
                    TitleBarComponent(
                        title = "임보처 구해요",
                        isMenu = false,
                        onClickBack = {
                            val route = navController.currentBackStackEntry?.destination?.route
                            if (route == ShelterSafeType.SAFE_SHELTER_COMPOSABLE.name) {
                                finish()
                            } else {
                                navController.popBackStack(
                                    route = ShelterSafeType.SAFE_SHELTER_COMPOSABLE.name,
                                    inclusive = false
                                )
                            }
                        },
                        onClickMenu = {

                        }
                    )

                    NavHost(
                        navController = navController,
                        startDestination = ShelterSafeType.SAFE_SHELTER_COMPOSABLE.name
                    ) {
                        composable(ShelterSafeType.SAFE_SHELTER_COMPOSABLE.name) {
                            SafeShelterSuccessScreen(navController = navController)
                        }

                        composable("${ShelterSafeType.ANIMAL_INFO_DETAIL.name}/{id}") {
                            val id = it.arguments?.getString("id").toString()
                            ShelterDetailSuccessScreen(
                                id = id.toInt()
                            )
                        }
                    }
                }
            }
        }
    }
}