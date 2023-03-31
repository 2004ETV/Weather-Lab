package com.weather.compose.weather_api.data

import com.weather.compose.core.entity.Either
import com.weather.compose.core.entity.ErrorReason
import com.weather.compose.weather_api.domain.models.WeatherDomain

interface WeatherRepository {
    suspend fun getCurrentWeather(cityName: String): Either<ErrorReason, WeatherDomain>
}