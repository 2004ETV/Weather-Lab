package com.weather.compose.forecast.presentation

import androidx.compose.runtime.Immutable
import com.weather.compose.forecast.presentation.models.ForecastItemUi

@Immutable
internal data class ForecastUiState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val city: String = "",
    val weather: ForecastItemUi? = null,
    val isError: Boolean = false,
) {
    companion object {
        val Empty = ForecastUiState()
    }
}

internal sealed class ForecastUiEvent {
    class OnCityInput(val city: String) : ForecastUiEvent()
    object OnLoadForecast : ForecastUiEvent()
    object OnRefresh : ForecastUiEvent()
    class OnShareForecast(val forecast: String): ForecastUiEvent()
}

internal sealed class ForecastUiEffect {
    class ShareForecast(val forecast: String): ForecastUiEffect()
}