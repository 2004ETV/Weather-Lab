package com.weather.compose.core.di

import android.content.Context
import com.weather.compose.core.di.ComponentDependencies

interface CommonDependencies: ComponentDependencies {
    val context: Context
}
