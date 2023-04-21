// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(plugin.androidJUnit5)
    }
}

plugins {
    id("com.android.application") version plugin.androidPluginVersion apply false
    id("com.android.library") version plugin.androidPluginVersion apply false
    kotlin("android") version plugin.kotlinAndroidVersion apply false
    kotlin("plugin.serialization") version plugin.kotlinSerializationVersion apply false
    kotlin("jvm") version plugin.kotlinSerializationVersion apply false
}