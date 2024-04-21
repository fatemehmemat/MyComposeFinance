package com.example.mycomposefinance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

val bottomNavItems = listOf(
    BottomNavItem(
        id = 0,
        title = "Home",
        icon = Icons.Rounded.Home
    ),
    BottomNavItem(
        id = 1,
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),
    BottomNavItem(
        id = 2,
        title = "Notification",
        icon = Icons.Rounded.Notifications
    ),
    BottomNavItem(
        id = 3,
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    )
)

@Preview
@Composable
fun BottomNavigation(callBack: (id: Int) -> Unit) {
    var activeItem by remember {
        mutableStateOf(0)
    }
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            bottomNavItems.forEachIndexed { index, bottomNavItem ->
                NavigationBarItem(
                    selected = activeItem == index,
                    onClick = {
                        callBack.invoke(bottomNavItem.id)
                        activeItem = index
                    },
                    icon = {
                        Icon(
                            imageVector = bottomNavItem.icon,
                            contentDescription = bottomNavItem.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text=bottomNavItem.title,
                            color=MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}

data class BottomNavItem(val id: Int, val title: String, val icon: ImageVector)