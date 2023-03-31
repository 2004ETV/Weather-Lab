plugins {
    alias(libs.plugins.android.library)
    id("com.weather.compose.module.compose")
}

android {
    namespace = "com.weather.compose.core_ui"
}

dependencies {
    implementation(projects.core)
}