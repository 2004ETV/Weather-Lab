package com.weather.compose.sample.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.weather.compose.sample.navigation.NavGraphs

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    DestinationsNavHost(
        modifier = modifier,
        navGraph = NavGraphs.root,
        navController = navController,
        engine = rememberNavHostEngine(),
        dependenciesContainerBuilder = { dependency(currentNavigator()) }
    )
}