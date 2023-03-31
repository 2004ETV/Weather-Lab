plugins {
    alias(libs.plugins.android.library)
    id("com.weather.compose.module.dagger")
}

android {
    namespace = "com.weather.compose.core"
}

dependencies {
    implementation(libs.savedstate)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
}