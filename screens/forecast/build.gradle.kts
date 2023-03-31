plugins {
    alias(libs.plugins.android.library)
    id("com.weather.compose.module.screen")
}

android {
    namespace = "com.weather.compose.forecast"
}

dependencies {
    implementation(projects.weatherApi)
}