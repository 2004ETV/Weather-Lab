package com.weather.compose.weather_api.domain.models

class WeatherDomain(
    val weather: List<CurrentWeatherDomain>,
    val main: MainWeatherDomain,
    val name: String,
)

class CurrentWeatherDomain(
    val description: String,
    val icon: String
)

class MainWeatherDomain(
    val temp: Double,
    val feelsLike: Double,
    val minTemp: Double,
    val maxTemp: Double,
)