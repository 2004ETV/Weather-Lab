package com.weather.compose.forecast.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weather.compose.forecast.presentation.ForecastViewModel
import com.weather.compose.core.di.viewmodel.DaggerViewModelFactory
import com.weather.compose.core.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
internal interface ForecastViewModelModule {

    companion object {
        @Provides
        fun provideForecastViewModelFactory(
            creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
        ): ViewModelProvider.Factory = DaggerViewModelFactory(creators)
    }

    @Binds
    @ViewModelKey(ForecastViewModel::class)
    @IntoMap
    fun bindForecastViewModel(viewModel: ForecastViewModel): ViewModel
}