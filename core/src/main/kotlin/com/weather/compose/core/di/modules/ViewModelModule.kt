package com.weather.compose.core.di.modules

import androidx.lifecycle.ViewModel
import com.weather.compose.core.di.viewmodel.DaggerViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
interface ViewModelModule {

    companion object {

        @Provides
        fun provideViewModelFactory(
            factoriesMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
        ): DaggerViewModelFactory {
            return DaggerViewModelFactory(factoriesMap)
        }
    }
}
