package com.llama.petmilly_client.presentation.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.llama.petmilly_client.R

enum class HomeRoute(
    val route: String,
    @StringRes val contentDescription: Int,
    val icon: ImageVector
) {
    HOME(route = "HomeScreen", contentDescription = R.string.nav_home, icon = Icons.Filled.Home),
    CHAT(route = "ChatScreen", contentDescription = R.string.nav_chat, icon = Icons.Filled.MailOutline),
    HEART(route = "FavoriteScreen", contentDescription = R.string.nav_heart, icon = Icons.Filled.Favorite),
    NOTIFICATION(route = "NotificationScreen", contentDescription = R.string.nav_notification, icon = Icons.Filled.Notifications),
    PERSON(route = "PersonScreen", contentDescription = R.string.nav_menu, icon = Icons.Filled.Menu)
}


//sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
//    object Home : BottomNavItem("펫밀리", R.drawable.img_petmilly_chatting, "home")
//    object Chatting : BottomNavItem("채팅", R.drawable.img_petmilly_chatting, "my_network")
//    object Heart : BottomNavItem("관심", R.drawable.img_petmilly_chatting, "add_post")
//    object Notification : BottomNavItem("알림", R.drawable.img_petmilly_chatting, "notification")
//    object Person : BottomNavItem("MY", R.drawable.img_petmilly_chatting, "my")
//}