package com.weather.compose.sample.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun AppHost() {
    val navController = rememberNavController()

    Scaffold { paddingValues ->
        AppNavigation(
            modifier = Modifier.padding(paddingValues),
            navController = navController
        )
    }
}