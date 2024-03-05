
apply {
    from("$rootDir/android-library-build.gradle")
}
plugins{
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}
dependencies{
    "implementation"(project(":image-list:datasource"))
    "implementation"(project(":image-list:domain"))
    "implementation"(project(":core"))
    "implementation"(project(":constants"))
    "implementation"("org.jetbrains.kotlinx:kotlinx-serialization-json:1.")

}