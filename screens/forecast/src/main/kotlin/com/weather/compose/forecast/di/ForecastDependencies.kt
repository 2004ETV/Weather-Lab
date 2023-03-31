package com.weather.compose.forecast.di

import com.weather.compose.core.di.CommonDependencies
import com.weather.compose.weather_api.data.WeatherRepository

interface ForecastDependencies : CommonDependencies {
    fun weatherRepository(): WeatherRepository
}