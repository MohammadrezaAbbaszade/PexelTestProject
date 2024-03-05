plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{
    "implementation"(project(":image-list:domain"))
    "implementation"(project(":image-list:datasource"))
    "implementation"(project(":core"))
    "implementation"(Kotlinx.coroutinesCore)
}