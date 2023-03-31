package com.weather.compose.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal class WeatherErrorNetwork(
    @Json(name = "cod")
    val code: String,
    @Json(name = "message")
    val message: String,
)
