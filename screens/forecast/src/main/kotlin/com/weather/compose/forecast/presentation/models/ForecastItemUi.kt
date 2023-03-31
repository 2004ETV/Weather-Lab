package com.weather.compose.forecast.presentation.models

internal class ForecastItemUi(
    val weather: List<CurrentForecastItemUi>,
    val main: MainForecastItemUi,
    val name: String,
)

class CurrentForecastItemUi(
    val description: String,
    val icon: String
)

class MainForecastItemUi(
    val temp: Double,
    val feelsLike: Double,
    val minTemp: Double,
    val maxTemp: Double,
)