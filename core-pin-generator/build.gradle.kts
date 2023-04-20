plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {

    defaultConfig {
        minSdk = appConfig.minSdk
        compileSdk = appConfig.compileSdk
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core-base"))

    implementation(google.dagger)

    kapt(google.daggerCompile)
}