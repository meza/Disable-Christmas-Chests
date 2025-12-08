pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.architectury.dev")
        maven("https://maven.minecraftforge.net")
        maven("https://maven.neoforged.net/releases/")
        maven("https://maven.kikugie.dev/releases")
        maven("https://maven.kikugie.dev/snapshots")
    }
}

plugins {
    id("gg.meza.stonecraft") version "1.8.+"
    id("dev.kikugie.stonecutter") version "0.7.11"
}

stonecutter {
//    centralScript = "build.gradle.kts"
//    kotlinController = true

    shared {
        fun mc(version: String, vararg loaders: String) {
            for (it in loaders) version("$version-$it", version)
        }

        mc("1.21.1", "fabric")
        mc("1.21.4", "fabric")
        mc("1.21.9", "fabric")

        vcsVersion = "1.21.9-fabric"
    }

    create(rootProject)
}

rootProject.name = "DisableChristmasChests"
