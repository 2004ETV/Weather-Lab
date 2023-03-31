package com.weather.compose.sample.navigation

import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.weather.compose.forecast.presentation.destinations.ForecastScreenDestination

object NavGraphs {
    val forecast = object : NavGraphSpec {
        override val route = "forecast"
        override val startRoute = ForecastScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            ForecastScreenDestination,
        ).routedIn(this).associateBy { it.route }
    }

    val root = object : NavGraphSpec {
        override val route = "root"
        override val startRoute = forecast
        override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
        override val nestedNavGraphs = listOf(forecast)
    }
}