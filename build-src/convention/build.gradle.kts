plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

gradlePlugin {
    plugins {
        register("build-config-plugin") {
            id = "com.weather.compose.build.config"
            implementationClass = "com.weather.compose.convention.plugins.BuildConfigPlugin"
        }
        register("screen-module-plugin") {
            id = "com.weather.compose.module.screen"
            implementationClass = "com.weather.compose.convention.plugins.ScreenModulePlugin"
        }
        register("dagger-module-plugin") {
            id = "com.weather.compose.module.dagger"
            implementationClass = "com.weather.compose.convention.plugins.DaggerModulePlugin"
        }
        register("compose-module-plugin") {
            id = "com.weather.compose.module.compose"
            implementationClass = "com.weather.compose.convention.plugins.ComposeModulePlugin"
        }
    }
}

dependencies {
    implementation(libs.android.gradle)
    implementation(libs.kotlin.gradle)
    implementation(libs.google.ksp)
    compileOnly(gradleApi())
}