package com.weather.compose.weather_api.data

import android.content.Context
import com.weather.compose.core.entity.Either
import com.weather.compose.core.entity.ErrorReason
import com.weather.compose.core.entity.map
import com.weather.compose.weather_api.data.weather.remote.WeatherApiDataSource
import com.weather.compose.weather_api.data.weather.remote.models.WeatherResponse
import com.weather.compose.weather_api.data.weather.remote.models.mappers.toWeather
import com.weather.compose.weather_api.domain.models.WeatherDomain
import javax.inject.Inject

internal class WeatherRepositoryImpl @Inject constructor(
    private val context: Context,
    private val weatherApi: WeatherApiDataSource
) : WeatherRepository {

    override suspend fun getCurrentWeather(cityName: String): Either<ErrorReason, WeatherDomain> {
        return weatherApi.getCurrentWeather(
            cityName = cityName,
            lang = context.resources.configuration.locales[0].country
        ).map(WeatherResponse::toWeather)
    }
}