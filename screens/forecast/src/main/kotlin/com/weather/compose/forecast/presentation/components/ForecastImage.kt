package com.weather.compose.forecast.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.weather.compose.core_ui.components.FadePlaceholder
import com.weather.compose.forecast.R

@Composable
internal fun ForecastImage(
    image: String,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://openweathermap.org/img/wn/$image@4x.png")
            .crossfade(true)
            .build(),
        contentDescription = stringResource(R.string.weather_image),
        contentScale = ContentScale.Crop
    ) {
        when (painter.state) {
            AsyncImagePainter.State.Empty -> {
                FadePlaceholder(modifier = Modifier.fillMaxSize())
            }
            is AsyncImagePainter.State.Error -> {
                FadePlaceholder(modifier = Modifier.fillMaxSize())
            }
            is AsyncImagePainter.State.Loading -> {
                FadePlaceholder(modifier = Modifier.fillMaxSize())
            }
            is AsyncImagePainter.State.Success -> SubcomposeAsyncImageContent()
        }
    }
}