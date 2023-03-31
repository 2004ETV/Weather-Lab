package com.weather.compose.network.di.modules

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.addAdapter
import com.weather.compose.core.di.scope.AppScope
import com.weather.compose.network.BuildConfig
import com.weather.compose.network.EitherWeatherAdapterFactory
import com.weather.compose.network.interceptors.WeatherApiKeyInterceptor
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
interface NetworkModule {

    companion object {

        @OptIn(ExperimentalStdlibApi::class)
        @Provides
        fun provideMoshi(): Moshi {
            return Moshi.Builder()
                .addAdapter(Rfc3339DateJsonAdapter().nullSafe())
                .build()
        }

        @Provides
        @IntoSet
        fun provideNewsApiKeyInterceptor(): Interceptor = WeatherApiKeyInterceptor()

        @Provides
        @AppScope
        fun provideOkHttpClient(
            interceptors: Set<@JvmSuppressWildcards Interceptor>
        ): OkHttpClient {
            return OkHttpClient.Builder()
                .apply { interceptors.forEach(::addInterceptor) }
                .callTimeout(5, TimeUnit.SECONDS)
                .build()
        }

        @Provides
        @AppScope
        fun provideRetrofit(
            client: OkHttpClient,
            moshi: Moshi
        ): Retrofit {
            return Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.WEATHER_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(EitherWeatherAdapterFactory())
                .build()
        }
    }
}