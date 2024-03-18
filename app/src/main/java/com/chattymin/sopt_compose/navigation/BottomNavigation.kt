package com.chattymin.sopt_compose.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(navController: NavController) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    val items = listOf(
        BottomNavItem.Android,
        BottomNavItem.Home,
        BottomNavItem.My
    )

    NavigationBar {
        items.forEachIndexed { _, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = stringResource(id = item.title),
                    )
                },
                label = { Text(text = stringResource(id = item.title)) },
                selected = item.route == backStackEntry.value?.destination?.route,
                onClick = {
                    navController.navigate(item.route){
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}