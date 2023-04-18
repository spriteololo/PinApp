plugins {
    id("com.android.library")
    kotlin("android")
}

android {

    namespace = "com.test.core_android_base"

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
    implementation(project(":core-base"))

    implementation(androidX.appCompat)
    implementation(androidX.core)
    implementation(androidX.fragment)
    implementation(androidX.viewBinding)
    implementation(google.material)
    implementation(reactiveX.rxJava)
    implementation(reactiveX.rxAndroid)
}