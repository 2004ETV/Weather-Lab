package com.weather.compose.core.di

interface HasComponentDependencies {
    val dependencies: ComponentDependenciesProvider
}
