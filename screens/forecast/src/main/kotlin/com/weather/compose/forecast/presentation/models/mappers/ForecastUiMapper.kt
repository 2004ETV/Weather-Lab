package com.weather.compose.forecast.presentation.models.mappers

import com.weather.compose.forecast.presentation.models.CurrentForecastItemUi
import com.weather.compose.forecast.presentation.models.ForecastItemUi
import com.weather.compose.forecast.presentation.models.MainForecastItemUi
import com.weather.compose.weather_api.domain.models.CurrentWeatherDomain
import com.weather.compose.weather_api.domain.models.MainWeatherDomain
import com.weather.compose.weather_api.domain.models.WeatherDomain

internal fun WeatherDomain.toForecastItemUi(): ForecastItemUi {
    return ForecastItemUi(
        weather = weather.map(CurrentWeatherDomain::toCurrentForecastItemUi),
        main = main.toMainForecastItemUi(),
        name = name,
    )
}

internal fun CurrentWeatherDomain.toCurrentForecastItemUi(): CurrentForecastItemUi {
    return CurrentForecastItemUi(
        description = description,
        icon = icon
    )
}

internal fun MainWeatherDomain.toMainForecastItemUi(): MainForecastItemUi {
    return MainForecastItemUi(
        temp = temp,
        feelsLike = feelsLike,
        minTemp = minTemp,
        maxTemp = maxTemp,
    )
}