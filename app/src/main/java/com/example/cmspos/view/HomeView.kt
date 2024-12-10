package com.example.cmspos.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Cog
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.User

@Composable
fun DashboardScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedTab = selectedTab, onTabSelected = { selectedTab = it })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedTab) {
                0 -> HomeScreen()
                1 -> SettingsScreen()
                2 -> ProfileScreen()
            }
        }
    }
}

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 4.dp
    ) {
        // Home Tab
        NavigationBarItem(
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            icon = {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp) // Icon size
                )
            },
            label = {
                Text(
                    text = "Home",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (selectedTab == 0) Color.White else MaterialTheme.colorScheme.onSurface
                )
            },
            alwaysShowLabel = true,
            modifier = Modifier.background(
                color = if (selectedTab == 0) MaterialTheme.colorScheme.primary else Color.Transparent,
                shape = MaterialTheme.shapes.medium
            )
        )

        // Settings Tab
        NavigationBarItem(
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            icon = {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.Cog,
                    contentDescription = "Settings",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (selectedTab == 1) Color.White else MaterialTheme.colorScheme.onSurface
                )
            },
            alwaysShowLabel = true,
            modifier = Modifier.background(
                color = if (selectedTab == 1) MaterialTheme.colorScheme.primary else Color.Transparent,
                shape = MaterialTheme.shapes.medium
            )
        )

        // Profile Tab
        NavigationBarItem(
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            icon = {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.User,
                    contentDescription = "Profile",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Profile",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (selectedTab == 2) Color.White else MaterialTheme.colorScheme.onSurface
                )
            },
            alwaysShowLabel = true,
            modifier = Modifier.background(
                color = if (selectedTab == 2) MaterialTheme.colorScheme.primary else Color.Transparent,
                shape = MaterialTheme.shapes.medium
            )
        )
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Home Screen!", style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Settings Screen", style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Profile Screen", style = MaterialTheme.typography.titleLarge)
    }
}
