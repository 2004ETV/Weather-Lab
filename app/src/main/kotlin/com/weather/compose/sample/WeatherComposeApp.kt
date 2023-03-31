package com.weather.compose.sample

import android.app.Application
import com.weather.compose.core.di.ComponentDependenciesProvider
import com.weather.compose.core.di.HasComponentDependencies
import com.weather.compose.sample.di.DaggerAppComponent
import javax.inject.Inject

class WeatherComposeApp : Application(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
    }
}