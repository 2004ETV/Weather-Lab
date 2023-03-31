package com.weather.compose.forecast.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.weather.compose.forecast.R
import com.weather.compose.forecast.presentation.models.ForecastItemUi

@Composable
internal fun ForecastContent(
    forecast: ForecastItemUi?,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        ForecastTitleText(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            title = R.string.right_now
        )
        Spacer(modifier = Modifier.height(4.dp))
        AnimatedContent(targetState = forecast, label = "") {
            ForecastDescriptionText(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                description = it?.weather?.get(0)?.description ?: stringResource(id = R.string.forecast_description)
            )
        }
        Spacer(modifier = Modifier.height(28.dp))
        ForecastTempBlock(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            image = forecast?.weather?.get(0)?.icon,
            temp = forecast?.main?.temp,
            feelsLike = forecast?.main?.feelsLike,
            minTemp = forecast?.main?.minTemp,
            maxTemp = forecast?.main?.maxTemp
        )
    }
}