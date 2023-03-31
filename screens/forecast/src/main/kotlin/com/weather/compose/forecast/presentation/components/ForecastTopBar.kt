package com.weather.compose.forecast.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun ForecastTopBar(
    city: String,
    isError: Boolean,
    modifier: Modifier = Modifier,
    onCityChanged: (String) -> Unit,
    onLoad: () -> Unit,
    onShare: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ForecastSearchLocationTextField(
            modifier = Modifier
                .height(55.dp)
                .fillMaxWidth(),
            city = city,
            isError = isError,
            onCityChanged = { onCityChanged(it) },
            onSearch = { onLoad() },
            onLoad = { onShare() }
        )
    }
}