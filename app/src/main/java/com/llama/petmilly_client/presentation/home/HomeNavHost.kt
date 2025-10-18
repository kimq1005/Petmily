package com.llama.petmilly_client.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.presentation.chatscreen.ChatEntityScreen
import com.llama.petmilly_client.presentation.favoritescreen.FavoriteScreen
import com.llama.petmilly_client.presentation.home.items.MainBottomBar
import com.llama.petmilly_client.presentation.myProfile.MyProfileScreen
import com.llama.petmilly_client.presentation.notificationscreen.NotificationScreen

@Composable
fun HomeNavHost() {
    val navController = rememberNavController()

    Surface {
        Scaffold(
            content = { contentPadding ->
                NavHost(
                    modifier = Modifier
                        .padding(contentPadding),
                    navController = navController,
                    startDestination = HomeRoute.HOME.route
                ) {
                    composable(route = HomeRoute.HOME.route) {
                        HomeMapSuccessScreen()
                    }

                    composable(route = HomeRoute.CHAT.route) {
                        ChatEntityScreen()
                    }

                    composable(route = HomeRoute.HEART.route) {
                        FavoriteScreen(navController = navController)
                    }

                    composable(route = HomeRoute.NOTIFICATION.route) {
                        NotificationScreen(navController = navController)
                    }

                    composable(route = HomeRoute.PERSON.route) {
                        MyProfileScreen()
                    }
                }
            },
            bottomBar = {
                MainBottomBar(
                    navController = navController
                )
            }
        )
    }
}