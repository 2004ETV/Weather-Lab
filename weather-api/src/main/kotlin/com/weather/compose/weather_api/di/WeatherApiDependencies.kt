package com.weather.compose.weather_api.di

import com.weather.compose.core.di.CommonDependencies
import retrofit2.Retrofit

interface WeatherApiDependencies : CommonDependencies {
    fun getRetrofit(): Retrofit
}