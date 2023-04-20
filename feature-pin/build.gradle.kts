plugins {
    id("com.android.library")
    id("kotlin-parcelize")
    kotlin("plugin.serialization")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.test.feature_pin"


    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        minSdk = appConfig.minSdk
        compileSdk = appConfig.compileSdk
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core-android-base"))
    implementation(project(":core-base"))
    implementation(project(":core-design"))

    implementation(androidX.core)
    implementation(androidX.appCompat)
    implementation(androidX.fragment)
    implementation(google.dagger)
    implementation(google.material)
    implementation(kotlinx.serializationJson)

    kapt(google.daggerCompile)
}