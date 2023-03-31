package com.weather.compose.forecast.presentation

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.weather.compose.forecast.di.forecastComponent
import com.ramcosta.composedestinations.annotation.Destination
import com.weather.compose.core_ui.di.daggerViewModel
import com.weather.compose.forecast.R
import com.weather.compose.forecast.presentation.components.ForecastContent
import com.weather.compose.forecast.presentation.components.ForecastTopBar
import kotlin.math.roundToInt

@Destination
@Composable
fun ForecastScreen() {
    val activity = LocalContext.current as Activity

    ForecastScreen(
        viewModel = daggerViewModel(factory = forecastComponent.getInstance(activity).viewModelFactory)
    )
}

@Composable
private fun ForecastScreen(
    viewModel: ForecastViewModel
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is ForecastUiEffect.ShareForecast -> {
                    startActivity(
                        context,
                        Intent.createChooser(
                            Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, effect.forecast)
                                type = "text/plain"
                            },
                            context.getString(R.string.сurrent_weather_forecast)
                        ),
                        null
                    )
                }
            }
        }
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
        onRefresh = { viewModel.sendEvent(ForecastUiEvent.OnRefresh) }) {
        Box(modifier = Modifier.fillMaxSize()) {
            ForecastContent(
                modifier = Modifier
                    .padding(top = 78.dp)
                    .fillMaxWidth()
                    .verticalScroll(state = rememberScrollState()),
                forecast = state.weather
            )
            ForecastTopBar(
                modifier = Modifier
                    .fillMaxWidth(),
                onShare = {
                    if (state.weather == null) {
                        Toast.makeText(
                            context,
                            R.string.forecast_send_message_exception,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.sendEvent(
                            ForecastUiEvent.OnShareForecast(
                                context.getString(
                                    R.string.forecast_send_message,
                                    state.weather!!.name,
                                    state.weather!!.main.temp.roundToInt().toString()
                                )
                            )
                        )
                    }
                },
                city = state.city,
                isError = state.isError,
                onCityChanged = { viewModel.sendEvent(ForecastUiEvent.OnCityInput(it)) },
                onLoad = { viewModel.sendEvent(ForecastUiEvent.OnLoadForecast) }
            )
        }
    }
}