import org.gradle.api.JavaVersion

object Versions {
    const val androidMinSdkVersion = 21
    const val androidTargetSdkVersion = 31
    const val androidCompileSdkVersion = 31
    const val libraryVersionName = "1.0.1"
    const val libraryVersionCode = 1
    const val kotlin = "1.6.0"
    val javaVersion = JavaVersion.VERSION_1_8
}

object App {
    const val id = "com.co.coco"
    const val versionName = "1.0.1"
    const val versionCode = 1
    const val dimension = "default"
    const val url = "\"https://kino.kz\""
}

object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
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
    const val exifinterface = "androidx.exifinterface:exifinterface:1.1.0"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.6"
}

object Kotlin {
    const val coroutinesVersion = "1.6.0"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    const val metadata = "org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.3.0"
}

object Network {
    private const val retrofitVersion = "2.9.0"
    private const val okHttpVersion = "4.9.1"
    private const val gsonVersion = "2.8.6"

    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    const val okHttpTls = "com.squareup.okhttp3:okhttp-tls:$okHttpVersion"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val retrofitCoroutines =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    const val retrofitXml = "com.squareup.retrofit2:converter-simplexml:2.5.0"
    const val gson = "com.google.code.gson:gson:$gsonVersion"
    const val chuckDebug = "com.github.chuckerteam.chucker:library:3.5.2"
    const val chuckRelease = "com.github.chuckerteam.chucker:library-no-op:3.5.2"
}

object ArchitectureComponents {
    private const val version = "2.2.0"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$version"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-common-java8:$version"
}