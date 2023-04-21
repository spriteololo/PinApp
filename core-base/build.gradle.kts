plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {

    namespace = "com.test.core_base"

    defaultConfig {
        minSdk = appConfig.minSdk
        compileSdk = appConfig.compileSdk
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(google.dagger)
    implementation(reactiveX.rxJava)
    implementation(reactiveX.rxAndroid)

    kapt(google.daggerCompile)
}