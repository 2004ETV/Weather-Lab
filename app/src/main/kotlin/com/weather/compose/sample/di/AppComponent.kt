package com.weather.compose.sample.di

import android.app.Application
import com.weather.compose.forecast.di.ForecastDependencies
import com.weather.compose.core.di.CommonDependencies
import com.weather.compose.core.di.scope.AppScope
import com.weather.compose.network.di.modules.NetworkModule
import com.weather.compose.sample.MainActivity
import com.weather.compose.sample.WeatherComposeApp
import com.weather.compose.sample.di.modules.AppModule
import com.weather.compose.sample.di.modules.ComponentDependenciesModule
import com.weather.compose.weather_api.di.WeatherApiDependencies
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        AppModule::class,
        ComponentDependenciesModule::class,
        NetworkModule::class
    ]
)
interface AppComponent :
    CommonDependencies,
    ForecastDependencies,
    WeatherApiDependencies {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(application: WeatherComposeApp)
    fun inject(mainActivity: MainActivity)
}