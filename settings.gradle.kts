pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "PinApp"
include(
        ":app",
        ":core-android-base",
        ":core-base",
        ":core-design",
        ":core-pin",
        ":feature-pin",
)
