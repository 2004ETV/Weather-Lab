import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.library)
    id("com.weather.compose.module.dagger")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.weather.compose.network"

    val apiKey = gradleLocalProperties(project.rootDir).getProperty("apiKey")

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "WEATHER_API_KEY", apiKey)
            buildConfigField("String", "WEATHER_URL", "\"https://api.openweathermap.org/\"")
        }
        getByName("release") {
            buildConfigField("String", "WEATHER_API_KEY", apiKey)
            buildConfigField("String", "WEATHER_URL", "\"https://api.openweathermap.org/\"")
        }
    }
}

dependencies {
    implementation(projects.core)

    implementation(libs.retrofit.client)
    implementation(libs.retrofit.moshi)

    implementation(libs.okhttp.client)
    debugImplementation(libs.okhttp.logginginterceptor)

    implementation(libs.androidx.core.ktx)

    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)
    ksp(libs.moshi.compiler)
}