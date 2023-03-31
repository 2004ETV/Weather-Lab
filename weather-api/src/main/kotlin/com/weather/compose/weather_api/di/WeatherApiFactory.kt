package com.weather.compose.weather_api.di

import com.weather.compose.weather_api.data.WeatherRepository

object WeatherApiFactory {
    fun create(deps: WeatherApiDependencies): WeatherRepository =
        DaggerWeatherApiComponent.factory().create(deps).repository
}