package com.weather.compose.forecast.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.compose.core.entity.map
import com.weather.compose.core.entity.unpack
import com.weather.compose.forecast.presentation.models.mappers.toForecastItemUi
import com.weather.compose.weather_api.data.WeatherRepository
import com.weather.compose.weather_api.domain.models.WeatherDomain
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ForecastViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ForecastUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<ForecastUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: ForecastUiEvent) {
        when (event) {
            is ForecastUiEvent.OnCityInput -> {
                _state.update { it.copy(city = event.city, isError = false) }
            }

            is ForecastUiEvent.OnLoadForecast -> {
                viewModelScope.launch { loadCity() }
            }

            is ForecastUiEvent.OnRefresh -> {
                viewModelScope.launch { loadCity() }
            }

            is ForecastUiEvent.OnShareForecast -> {
                viewModelScope.launch { _effect.emit(ForecastUiEffect.ShareForecast(event.forecast)) }
            }
        }
    }

    private suspend fun loadCity() {
        weatherRepository.getCurrentWeather(cityName = _state.value.city.trim())
            .map(WeatherDomain::toForecastItemUi).unpack(
                success = { weather ->
                    _state.update {
                        it.copy(
                            weather = weather,
                            isError = false,
                        )
                    }
                },
                error = {
                    _state.update {
                        it.copy(
                            isError = true,
                            weather = null
                        )
                    }
                }
            )
    }
}