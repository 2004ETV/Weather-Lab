package com.weather.compose.sample.di.modules

import com.weather.compose.forecast.di.ForecastDependencies
import com.weather.compose.core.di.ComponentDependencies
import com.weather.compose.core.di.ComponentDependenciesKey
import com.weather.compose.sample.di.AppComponent
import com.weather.compose.weather_api.di.WeatherApiDependencies
import com.weather.compose.weather_api.di.WeatherApiFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface ComponentDependenciesModule {

    companion object {

        @Provides
        fun provideWeatherApi(appComponent: AppComponent) = WeatherApiFactory.create(appComponent)
    }

    @Binds
    @IntoMap
    @ComponentDependenciesKey(ForecastDependencies::class)
    fun bindForecastDeps(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(WeatherApiDependencies::class)
    fun bindWeatherApiDeps(appComponent: AppComponent): ComponentDependencies
}