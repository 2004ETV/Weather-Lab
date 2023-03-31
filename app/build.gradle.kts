 plugins {
    alias(libs.plugins.android.application)
    id("com.weather.compose.module.screen")
    id("com.weather.compose.module.dagger")
}

android {
    namespace = "com.weather.compose.sample"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.weather.compose.sample"
        versionCode = 1
        versionName = "1.0"

        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        packagingOptions {
            resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }

        testOptions {
            animationsDisabled = true
        }
    }
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {

    implementation(projects.network)

    implementation(projects.weatherApi)

    implementation(projects.screens.forecast)

    implementation(libs.savedstate)

    androidTestImplementation(libs.test.runner)
    androidTestImplementation(libs.test.rules)
    androidTestImplementation(libs.compose.test)

    implementation(libs.androidx.splashscreen)

    implementation(libs.byteBuddy)
    implementation(libs.byteBuddyAndroid)

    implementation(libs.retrofit.client)
    implementation(libs.retrofit.moshi)

    androidTestImplementation(libs.okhttpMock)
    androidTestImplementation(libs.moshi.adapters)

    implementation(libs.okhttp.client)
}