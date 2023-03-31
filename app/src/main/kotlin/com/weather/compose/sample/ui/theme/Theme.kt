package com.weather.compose.sample.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.weather.compose.sample.R

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    onPrimary = MediumSeaGreen,
    onBackground = RaisinBlack,
    background = ChineseBlack
)

private val LightColorScheme = lightColorScheme(
    primary = ChineseBlack,
    onPrimary = MediumSeaGreen,
    onBackground = Color.White,
    background = Cultured
)

@Composable
fun WeatherComposeSampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val view = LocalView.current
    (view.context as? Activity)?.window
        ?: throw Exception(stringResource(R.string.window_exception))
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = !darkTheme,
    )
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}