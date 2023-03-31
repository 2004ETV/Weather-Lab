package com.weather.compose.weather_api.data.weather.remote

import com.weather.compose.core.entity.Either
import com.weather.compose.core.entity.ErrorReason
import com.weather.compose.weather_api.data.weather.remote.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface WeatherApiDataSource {

    companion object {
        const val UNITS = "metric"
    }

    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("units") units: String = UNITS,
        @Query("lang") lang: String
    ): Either<ErrorReason, WeatherResponse>
}