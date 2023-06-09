pluginManagement {
    plugins {
        // Update this in libs.version.toml when you change it here
        kotlin("jvm") version "1.8.21"
        kotlin("plugin.serialization") version "1.8.21"

        // Update this in libs.version.toml when you change it here
        id("io.gitlab.arturbosch.detekt") version "1.21.0-RC2"

        id("com.github.jakemarsden.git-hooks") version "0.0.1"
        id("com.github.johnrengelman.shadow") version "5.2.0"
    }
}

rootProject.name = "speedrunbot"

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}
