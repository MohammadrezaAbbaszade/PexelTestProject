pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PexelTestProject"
include(":app")
include(":core")
include(":constants")
include(":image-list")
include(":image-list:datasource")
include(":image-list:domain")
include(":image-list:usecase")
include(":image-list:ui-imageList")
include(":image-list:ui-imageDetail")
