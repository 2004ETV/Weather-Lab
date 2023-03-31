package com.weather.compose.convention.plugins

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class BuildConfigPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project.plugins) {
            apply("org.jetbrains.kotlin.android")
            apply("kotlin-parcelize")
        }
        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            with(androidExtension) {
                applyAndroidSettings(project)
                applyBuildTypes()
                applyJava8(project)
                applyBaseDependencies(project)
            }
        }
    }

    private fun BaseExtension.applyAndroidSettings(project: Project) {
        compileSdkVersion(project.ANDROID_COMPILE_SDK_VERSION)
        defaultConfig {
            minSdk = project.ANDROID_MIN_SDK_VERSION
            targetSdk = project.ANDROID_TARGET_SDK_VERSION
        }
    }

    private fun BaseExtension.applyBuildTypes() {
        buildTypes {
            getByName("debug") {
                if (this@applyBuildTypes is AppExtension) {
                    versionNameSuffix = "-debug"
                    applicationIdSuffix = ".debug"
                }
            }
            getByName("release")
        }
    }

    private fun BaseExtension.applyJava8(project: Project) {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        project.tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    private fun applyBaseDependencies(project: Project) {
        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
        project.dependencies {
            add("implementation", libs.findLibrary("kotlinx-coroutines").get())
            add("implementation", libs.findLibrary("timber").get())
        }
    }
}