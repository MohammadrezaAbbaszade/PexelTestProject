plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("realm-android")
}

android {
    namespace = "com.example.pexeltestproject"
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.appId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation (project(":constants"))
    implementation (project(":image-list:datasource"))
    implementation (project(":image-list:framework"))
    implementation (project(":navigator"))
    implementation (project(":image-list:domain"))
    implementation (project(":image-list:usecase"))
    implementation (project(":image-list:ui-imageList"))
    implementation (project(":image-list:ui-imageDetail"))
    implementation (project(":core"))
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(Google.material)
    implementation(Hilt.android)
    kapt(Hilt.compiler)
    implementation(AndroidX.constraintlayout)
    testImplementation(JUnit.jUnit)
    implementation(Network.gson)
    implementation(Network.retrofit)
    implementation(Network.loggingInterceptor)
    implementation(Network.gsonConverter)
    androidTestImplementation(AndroidXTest.jUnitInstrumentTest)
    androidTestImplementation(AndroidXTest.espresso)
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.1.0")
    androidTestImplementation ("androidx.test:runner:1.1.0")
    androidTestImplementation ("androidx.test:rules:1.1.0")
}