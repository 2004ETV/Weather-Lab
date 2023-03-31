package com.weather.compose.weather_api.di

import com.weather.compose.weather_api.data.WeatherRepository
import com.weather.compose.weather_api.di.modules.WeatherApiModule
import dagger.Component

@Component(
    modules = [WeatherApiModule::class],
    dependencies = [WeatherApiDependencies::class]
)
interface WeatherApiComponent {

    @Component.Factory
    interface Factory {
        fun create(deps: WeatherApiDependencies): WeatherApiComponent
    }

    val repository: WeatherRepository
}