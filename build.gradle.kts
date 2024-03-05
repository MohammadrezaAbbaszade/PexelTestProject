// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.22" apply false
    id("com.android.library") version "8.2.1" apply false
}

buildscript {
    dependencies {
        classpath(Build.hiltAndroid)
        classpath(AndroidX.navigation_safe_arg)
        classpath(Build.androidBuildTools)
        classpath ("io.realm:realm-gradle-plugin:10.15.1")
    }
}