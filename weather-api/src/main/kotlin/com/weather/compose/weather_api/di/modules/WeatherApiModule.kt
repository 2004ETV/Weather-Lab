package com.weather.compose.weather_api.di.modules

import com.weather.compose.weather_api.data.WeatherRepository
import com.weather.compose.weather_api.data.WeatherRepositoryImpl
import com.weather.compose.weather_api.data.weather.remote.WeatherApiDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal interface WeatherApiModule {

    companion object {

        @Provides
        fun provideApiDataSource(
            retrofit: Retrofit
        ) : WeatherApiDataSource = retrofit.create(WeatherApiDataSource::class.java)
    }

    @Binds
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository
}