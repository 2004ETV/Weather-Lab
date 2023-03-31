package com.weather.compose.weather_api.data.weather.remote.models.mappers

import com.weather.compose.weather_api.data.weather.remote.models.CurrentWeatherResponse
import com.weather.compose.weather_api.data.weather.remote.models.MainWeatherResponse
import com.weather.compose.weather_api.data.weather.remote.models.WeatherResponse
import com.weather.compose.weather_api.domain.models.CurrentWeatherDomain
import com.weather.compose.weather_api.domain.models.MainWeatherDomain
import com.weather.compose.weather_api.domain.models.WeatherDomain

internal fun WeatherResponse.toWeather(): WeatherDomain {
    return WeatherDomain(
        weather = weather.map(CurrentWeatherResponse::toCurrentWeather),
        main = main.toMainWeather(),
        name = name,
    )
}

internal fun MainWeatherResponse.toMainWeather(): MainWeatherDomain {
    return MainWeatherDomain(
        temp = temp,
        feelsLike = feelsLike,
        minTemp = minTemp,
        maxTemp = maxTemp,
    )
}

internal fun CurrentWeatherResponse.toCurrentWeather(): CurrentWeatherDomain {
    return CurrentWeatherDomain(
        description = description,
        icon = icon
    )
}