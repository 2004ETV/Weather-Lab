package com.weather.compose.forecast.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.weather.compose.forecast.R
import kotlin.math.roundToInt

@Composable
internal fun ForecastTempBlock(
    image: String?,
    temp: Double?,
    feelsLike: Double?,
    minTemp: Double?,
    maxTemp: Double?,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ForecastImage(
            modifier = Modifier
                .size(120.dp)
                .clip(shape = CircleShape),
            image = image ?: ""
        )
        Spacer(modifier = Modifier.width(24.dp))
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedContent(
                targetState = temp,
                label = ""
            ) {
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "${it?.roundToInt() ?: stringResource(id = R.string.forecast_description)} °C",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            AnimatedContent(
                targetState = feelsLike,
                label = ""
            ) {
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "${
                        context.getString(
                            R.string.feels_like,
                            it?.roundToInt() ?: stringResource(id = R.string.forecast_description)
                        )
                    } °C",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary.copy(0.4F)
                )
            }
            AnimatedContent(
                targetState = minTemp,
                label = "",
            ) {
                ForecastDescriptionText(
                    modifier = Modifier.padding(top = 4.dp),
                    description = "${
                        context.getString(
                            R.string.min_temp,
                            it?.roundToInt() ?: stringResource(id = R.string.forecast_description)
                        )
                    } °C",
                    color = MaterialTheme.colorScheme.primary.copy(0.4F)
                )
            }
            AnimatedContent(
                targetState = maxTemp,
                label = ""
            ) {
                ForecastDescriptionText(
                    modifier = Modifier.padding(top = 4.dp),
                    description = "${
                        context.getString(
                            R.string.max_temp,
                            it?.roundToInt() ?: stringResource(id = R.string.forecast_description)
                        )
                    } °C",
                    color = MaterialTheme.colorScheme.primary.copy(0.4F)
                )
            }
        }
    }
}