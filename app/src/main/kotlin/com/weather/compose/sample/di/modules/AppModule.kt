package com.weather.compose.sample.di.modules

import android.app.Application
import android.content.Context
import com.weather.compose.core.di.InjectedKey
import com.weather.compose.core.di.scope.AppScope
import com.weather.compose.sample.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
interface AppModule {

    companion object {

        @AppScope
        @Provides
        fun provideContext(app: Application): Context = app.applicationContext

        @JvmStatic
        @Provides
        @Named(InjectedKey.Configuration.VERSION_NAME)
        fun provideAppVersionName(): String = BuildConfig.VERSION_NAME
    }
}