plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.test.pinapp"

    defaultConfig {
        applicationId = "com.test.pinapp"
        minSdk = appConfig.minSdk
        targetSdk = appConfig.targetSdk
        versionCode = appConfig.versionCode
        versionName = appConfig.versionName
        compileSdk = appConfig.compileSdk
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }


    buildFeatures {
        viewBinding = true
    }

    applicationVariants.all {
        outputs.forEach { output ->
            val outputImpl = output as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            outputImpl.outputFileName =
                "pinapp-$baseName-" +
                        "v_${appConfig.versionName.replace(".", "_")}(${appConfig.versionCode})" +
                        ".apk"
        }
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core-android-base"))
    implementation(project(":core-base"))
    implementation(project(":core-design"))

    implementation(project(":feature-pin"))

    implementation(androidX.appCompat)
    implementation(androidX.core)
    implementation(androidX.constraintLayout)
    implementation(androidX.fragment)
    implementation(reactiveX.rxJava)
    implementation(google.dagger)

    kapt(google.daggerCompile)
}