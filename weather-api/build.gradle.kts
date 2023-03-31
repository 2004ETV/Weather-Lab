plugins {
    alias(libs.plugins.android.library)
    id("com.weather.compose.module.dagger")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.weather.compose.weather_api"
}

dependencies {
    implementation(projects.core)
    implementation(projects.network)

    implementation(libs.androidx.paging.runtime.ktx)

    implementation(libs.retrofit.client)

    implementation(libs.moshi.kotlin)
    ksp(libs.moshi.compiler)
}