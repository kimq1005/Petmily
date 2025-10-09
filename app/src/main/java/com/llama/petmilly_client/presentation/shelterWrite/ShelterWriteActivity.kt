package com.llama.petmilly_client.presentation.shelterWrite

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.common.compnent.TitleBarComponent
import com.llama.petmilly_client.presentation.dialog.AlmostCompletedDialog
import dagger.hilt.android.AndroidEntryPoint
import llama.test.jetpack_dagger_plz.utils.Common
import llama.test.jetpack_dagger_plz.utils.Common.SHELTERDETAIL_SPECIES_SCREEN

@AndroidEntryPoint
class ShelterWriteActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: ShelterWriteViewModel = hiltViewModel()

            var isShowDialog by remember {
                mutableStateOf(false)
            }

            Column {
                TitleBarComponent(
                    title = stringResource(R.string.shelter_bar_title),
                    isMenu = false,
                    onClickBack = {
                        val popped = navController.popBackStack()
                        if (!popped) finish()
                    },
                    onClickMenu = { isShowDialog = true }
                )

                if (isShowDialog) {
                    AlmostCompletedDialog(
                        onDismiss = { isShowDialog = false },
                        onExit = { finish() }
                    )
                }

                NavHost(
                    navController = navController,
                    startDestination = SHELTERDETAIL_SPECIES_SCREEN
                ) {
                    composable(SHELTERDETAIL_SPECIES_SCREEN) {
                        ShelterWritePetInfoSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(Common.SHELTERDETAIL_1_PROFILE_SCREEN)
                            }
                        )
                    }

                    composable(Common.SHELTERDETAIL_1_PROFILE_SCREEN) {
                        ShelterWriteProfileSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(Common.SHELTERDETAIL_2_PROFILE_SCREEN)
                            }
                        )
                    }

                    composable(Common.SHELTERDETAIL_2_PROFILE_SCREEN) {
                        ShelterWriteProfileDetailInfoSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(Common.SHELTERDETAIL_3_PROFILE_SCREEN)
                            }
                        )
                    }

                    composable(Common.SHELTERDETAIL_3_PROFILE_SCREEN) {
                        ShelterWriteProfileThirdSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(Common.SHELTERDETAIL_4_PROFILE_SCREEN)
                            }
                        )
                    }

                    composable(Common.SHELTERDETAIL_4_PROFILE_SCREEN) {
                        ShelterWriteProfileLastSuccess(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(Common.SHELTERDETAIL_5_CONDITION_SCREEN)
                            }
                        )
                    }

                    composable(Common.SHELTERDETAIL_5_CONDITION_SCREEN) {
                        ShelterWriteConditionSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(Common.SHELTERDETAIL_6_CONDITION_SCREEN)
                            }
                        )
                    }

                    composable(Common.SHELTERDETAIL_6_CONDITION_SCREEN) {
                        ShelterWriteConditionLastSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(Common.SHELTERDETAIL_7_CHARMAPPEAL_SCREEN)
                            }
                        )
                    }

                    composable(Common.SHELTERDETAIL_7_CHARMAPPEAL_SCREEN) {
                        ShelterDetail_CharmAppeal_7_Screen(
                            navController = navController,
                            viewModel = viewModel,
                            activity = this@ShelterWriteActivity
                        )
                    }

                    composable(Common.SHELTERDETAIL_8_APPLICATION_SCREEN) {
                        ShelterDetail_8_Application_Period_Screen(
                            navController = navController,
                            viewModel = viewModel,
                            activity = this@ShelterWriteActivity
                        )
                    }
                }
            }
        }
    }
}


