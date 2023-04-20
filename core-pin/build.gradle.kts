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
    implementation(androidX.core)
    implementation(androidX.securityCrypto)
    implementation(reactiveX.rxJava)
//    implementation(reactiveX.rxAndroid)

    kapt(google.daggerCompile)
}