plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    "implementation"(project(":image-list:domain"))
    "implementation"(project(":core"))
    "implementation"(project(":constants"))
    "implementation"(Network.gson)
    "implementation"(Network.retrofit)
    "implementation"(Network.gsonConverter)
    "implementation"(Kotlinx.coroutinesCore)
    "implementation"(Ktor.clientSerialization)
    "implementation"(Hilt.core)
}