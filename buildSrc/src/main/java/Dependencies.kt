import org.gradle.api.JavaVersion

object Versions {
    const val androidMinSdkVersion = 21
    const val androidTargetSdkVersion = 31
    const val androidCompileSdkVersion = 31
    const val libraryVersionName = "1.0.1"
    const val libraryVersionCode = 1
    val javaVersion = JavaVersion.VERSION_1_8
}

object App {
    const val id = "com.co.coco"
    const val versionName = "1.0.1"
    const val versionCode = 1
}

object Dependencies {
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val cicerone = "com.github.terrakok:cicerone:7.1"
}

object Dagger {
    private const val daggerVersion = "2.38.1"
    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val compiler = "com.google.dagger:dagger-compiler:$daggerVersion"
    const val android = "com.google.dagger:dagger-android:$daggerVersion"
    const val androidSupport = "com.google.dagger:dagger-android-support:$daggerVersion"
    const val androidProcessor = "com.google.dagger:dagger-android-processor:$daggerVersion"
}

object UI {
    const val viewBindingKtx = "com.redmadrobot.extensions:viewbinding-ktx:4.2.1-0"
}

object TestDependencies {
    const val junit = "junit:junit:4.12"
}

object Android {
    const val appCompat = "androidx.appcompat:appcompat:1.4.0"
    const val material = "com.google.android.material:material:1.5.0"
    const val ktx = "androidx.core:core-ktx:1.7.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
}