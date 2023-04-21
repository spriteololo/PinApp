plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("de.mannodermaus.android-junit5")
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

    testImplementation(test.junit5)
    testRuntimeOnly(test.junit5Engine)
    testImplementation(test.junit5Params)
    testImplementation(test.mockito)
    testImplementation(test.mockitoKotlin)
    testImplementation(test.mockitoInline)
    testImplementation(test.assertj)
}