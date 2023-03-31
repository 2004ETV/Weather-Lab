package com.weather.compose.forecast.di

import android.app.Activity
import com.weather.compose.forecast.di.modules.ForecastViewModelModule
import com.weather.compose.core.di.featureComponent
import com.weather.compose.core.di.findComponentDependencies
import com.weather.compose.core.di.modules.ViewModelModule
import com.weather.compose.core.di.viewmodel.DaggerViewModelFactory
import com.weather.compose.forecast.di.DaggerForecastComponent
import dagger.Component

internal val forecastComponent = featureComponent<ForecastComponent, Activity> { activity ->
    DaggerForecastComponent.factory().create(activity.findComponentDependencies())
}

@Component(
    modules = [ViewModelModule::class, ForecastViewModelModule::class],
    dependencies = [ForecastDependencies::class]
)
internal interface ForecastComponent {

    @Component.Factory
    interface Factory {
        fun create(deps: ForecastDependencies): ForecastComponent
    }

    val viewModelFactory: DaggerViewModelFactory
}