package com.llama.petmilly_client.presentation.shelterWrite

import android.os.Build
import android.os.Bundle
import android.util.Log
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
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.common.compnent.TitleBarComponent
import com.llama.petmilly_client.presentation.dialog.AlmostCompletedDialog
import com.llama.petmilly_client.presentation.shelterWrite.model.ShelterWriteSideEffect
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectSideEffect

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

            viewModel.collectSideEffect { sideEffect ->
                when (sideEffect) {
                    is ShelterWriteSideEffect.Error -> {
                        Log.e("TAG", "ShelterWriteSideEffect: ${sideEffect.message}")
                    }

                    is ShelterWriteSideEffect.Finish -> {
                        finish()
                    }
                }
            }

            Column {
                TitleBarComponent(
                    title = stringResource(R.string.shelter_bar_title),
                    isMenu = true,
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
                    startDestination = ShelterRoute.SHELTER_WRITE_PET_INFO.route
                ) {
                    composable(ShelterRoute.SHELTER_WRITE_PET_INFO.route) {
                        ShelterWritePetInfoSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(ShelterRoute.SHELTER_WRITE_PROFILE.route)
                            }
                        )
                    }

                    composable(ShelterRoute.SHELTER_WRITE_PROFILE.route) {
                        ShelterWriteProfileSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(ShelterRoute.SHELTER_WRITE_PROFILE_DETAIL_INFO.route)
                            }
                        )
                    }

                    composable(ShelterRoute.SHELTER_WRITE_PROFILE_DETAIL_INFO.route) {
                        ShelterWriteProfileDetailInfoSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(ShelterRoute.SHELTER_WRITE_PROFILE_THIRD.route)
                            }
                        )
                    }

                    composable(ShelterRoute.SHELTER_WRITE_PROFILE_THIRD.route) {
                        ShelterWriteProfileThirdSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(ShelterRoute.SHELTER_WRITE_PROFILE_LAST.route)
                            }
                        )
                    }

                    composable(ShelterRoute.SHELTER_WRITE_PROFILE_LAST.route) {
                        ShelterWriteProfileLastSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(ShelterRoute.SHELTER_WRITE_CONDITION.route)
                            }
                        )
                    }

                    composable(ShelterRoute.SHELTER_WRITE_CONDITION.route) {
                        ShelterWriteConditionSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(ShelterRoute.SHELTER_WRITE_CONDITION_LAST.route)
                            }
                        )
                    }

                    composable(ShelterRoute.SHELTER_WRITE_CONDITION_LAST.route) {
                        ShelterWriteConditionLastSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(ShelterRoute.SHELTER_WRITE_CHARM_APPEAL.route)
                            }
                        )
                    }

                    composable(ShelterRoute.SHELTER_WRITE_CHARM_APPEAL.route) {
                        ShelterWriteCharmAppealSuccessScreen(
                            viewModel = viewModel,
                            onNavigate = {
                                navController.navigate(ShelterRoute.SHELTER_WRITE_APPLICATION_PERIOD.route)
                            }
                        )
                    }

                    composable(ShelterRoute.SHELTER_WRITE_APPLICATION_PERIOD.route) {
                        ShelterWriteApplicationPeriodSuccessScreen(
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}