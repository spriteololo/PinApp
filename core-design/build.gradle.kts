plugins {
    id("com.android.library")
    kotlin("android")
}

android {

    namespace = "com.test.core_design"

    defaultConfig {
        minSdk = appConfig.minSdk
        compileSdk = appConfig.compileSdk
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(google.material)
}