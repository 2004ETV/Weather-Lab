package com.weather.compose.weather_api.data.weather.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal class WeatherResponse(
    @Json(name = "weather")
    val weather: List<CurrentWeatherResponse>,
    @Json(name = "main")
    val main: MainWeatherResponse,
    @Json(name = "name")
    val name: String,
)

@JsonClass(generateAdapter = true)
internal class CurrentWeatherResponse(
    @Json(name = "description")
    val description: String,
    @Json(name = "icon")
    val icon: String
)

@JsonClass(generateAdapter = true)
internal class MainWeatherResponse(
    @Json(name = "temp")
    val temp: Double,
    @Json(name = "feels_like")
    val feelsLike: Double,
    @Json(name = "temp_min")
    val minTemp: Double,
    @Json(name = "temp_max")
    val maxTemp: Double,
)