package com.llama.petmilly_client.presentation.home.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.llama.petmilly_client.presentation.home.HomeRoute
import com.llama.petmilly_client.ui.theme.Category_Cliked

@Composable
fun MainBottomBar(
    navController: NavController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry
        ?.destination
        ?.route
        ?.let { currentRoute -> HomeRoute.values().find { route -> route.route == currentRoute }
        } ?: HomeRoute.HOME

    MainBottomBar(
        currentRoute = currentRoute,
        onItemClick = { newRoute ->
            navController.navigate(route = newRoute.route) {
                navController.graph.startDestinationRoute?.let {
                    popUpTo(it) {
                        saveState = true
                    }
                }
                this.launchSingleTop = true
                this.restoreState = true
            }
        }
    )
}

@Composable
private fun MainBottomBar(
    currentRoute: HomeRoute,
    onItemClick: (HomeRoute) -> Unit
) {
    Column {
        Divider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HomeRoute.values().forEach { route ->
                IconButton(
                    onClick = { onItemClick(route) }
                ) {
                    Icon(
                        imageVector = route.icon,
                        contentDescription = route.contentDescription.toString(),
                        tint = if (currentRoute == route) {
                            Category_Cliked
                        } else
                            Color.Black.copy(0.3f)
                    )
                }
            }
        }
    }

}