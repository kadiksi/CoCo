plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android-extensions")
    id ("kotlin-kapt")
}

android {
    compileSdk = Versions.androidCompileSdkVersion

    defaultConfig {
        minSdk = Versions.androidMinSdkVersion
        targetSdk = Versions.androidTargetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    flavorDimensions.add(App.dimension)
    productFlavors {
        create("dev") {
            dimension = App.dimension
            buildConfigField("String", "JMART_API_URL", App.url)
        }
//        create("prod") {
//            buildConfigField("String", "JMART_API_URL", "https://jmart.kz/api/4.0/")
//            buildConfigField("String", "JMART_NEW_API_URL", "https://jmart.kz/gw/")
//            buildConfigField("String", "JMART_JPOST_API_URL", "https://jmart.kz/jpost/api/")
//            buildConfigField("String", "JMART_WEB_VIEW_URL", "https://new.jmart.kz")
//        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":core-data"))
    implementation(Dagger.dagger)
    kapt(Dagger.compiler)
    implementation(Kotlin.coroutinesCore)
    implementation(Network.gson)
    implementation(Network.retrofit)
    implementation(Android.ktx)
}