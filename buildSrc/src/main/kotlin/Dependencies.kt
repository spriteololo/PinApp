internal object Global {

    const val kotlinVersion = "1.8.0"
}

class Plugin internal constructor() {

    val androidPluginVersion = "7.4.1"
    val kotlinAndroidVersion = Global.kotlinVersion
    val kotlinSerializationVersion = Global.kotlinVersion

    private val androidJUnit5Version = "1.8.2.0"

    val androidJUnit5 = "de.mannodermaus.gradle.plugins:android-junit5:$androidJUnit5Version"
}

val plugin = Plugin()

class AndroidX internal constructor() {

    private val appCompatVersion = "1.4.1"
    private val coreVersion = "1.7.0"
    private val constrainedLayoutVersion = "2.1.3"
    private val fragmentVersion = "1.4.1"
    private val viewBindingVersion = "7.1.2"

    val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:$constrainedLayoutVersion"
    val core = "androidx.core:core-ktx:$coreVersion"
    val fragment = "androidx.fragment:fragment-ktx:$fragmentVersion"
    val viewBinding = "androidx.databinding:viewbinding:$viewBindingVersion"
}

val androidX = AndroidX()

class Google internal constructor() {

    private val daggerVersion = "2.45"
    private val materialVersion = "1.6.1"

    val dagger = "com.google.dagger:dagger:$daggerVersion"
    val daggerCompile = "com.google.dagger:dagger-compiler:$daggerVersion"
    val material = "com.google.android.material:material:$materialVersion"
}

val google = Google()

class Test internal constructor() {

    private val assertJVersion = "3.23.1"
    private val junitVersion = "5.8.2"
    private val junitExtVersion = "1.1.3"
    private val espressoVersion = "3.4.0"
    private val kotlinVersion = Global.kotlinVersion
    private val mockitoVersion = "4.6.1"
    private val mockitoKotlinVersion = "4.0.0"

    val junitExt = "androidx.test.ext:junit-ktx:$junitExtVersion"
    val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"

    val assertj = "org.assertj:assertj-core:$assertJVersion"
    val kotlin = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"
    val mockito = "org.mockito:mockito-core:$mockitoVersion"
    val mockitoInline = "org.mockito:mockito-inline:$mockitoVersion"
    val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion"
    val mockitoAndroid = "org.mockito:mockito-android:$mockitoVersion"
    val junit5 = "org.junit.jupiter:junit-jupiter-api:$junitVersion"
    val junit5Params = "org.junit.jupiter:junit-jupiter-params:$junitVersion"
    val junit5Engine = "org.junit.jupiter:junit-jupiter-engine:$junitVersion"
}

val test = Test()


class Kotlinx internal constructor() {

    private val serializationJsonVersion = "1.3.2"

    val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationJsonVersion"
    val serializationProperties = "org.jetbrains.kotlinx:kotlinx-serialization-properties:$serializationJsonVersion"
}

val kotlinx = Kotlinx()


class ReactiveX internal constructor() {

    private val rxJavaVersion = "3.1.6"
    private val rxAndroidVersion = "3.0.2"

    val rxJava = "io.reactivex.rxjava3:rxjava:$rxJavaVersion"
    val rxAndroid = "io.reactivex.rxjava3:rxandroid:$rxAndroidVersion"
}

val reactiveX = ReactiveX()


class Other internal constructor() {

}

val other = Other()