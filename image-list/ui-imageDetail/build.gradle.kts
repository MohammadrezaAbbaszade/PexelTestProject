apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies{
    "implementation"(project(":image-list:domain"))
    "implementation"(project(":image-list:datasource"))
    "implementation"(project(":component"))
    "implementation"(project(":navigator"))
}