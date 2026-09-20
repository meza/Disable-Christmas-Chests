import gg.meza.stonecraft.mod

plugins {
    id("gg.meza.stonecraft")
}

val accessWidener =
    when {
        stonecutter.current.parsed >= "26.1" -> "disablechristmaschests.deobfuscated.accesswidener"
        else -> "disablechristmaschests.accesswidener"
    }
modSettings {
    clientOptions {
        darkBackground = true
        musicVolume = 0.0
        narrator = false
    }

    accessWidenerLocation = project.rootProject.layout.projectDirectory.file("src/main/resources/$accessWidener")
    accessWidenerProcessing = mod.isFabric
    variableReplacements = mapOf(
        "schema" to "\$schema",
        "accessWidener" to accessWidener,
        "minecraftCompatibilityVersion" to stonecutter.current.version,
        "modmenu_version" to mod.prop("modmenu_version", "*"),
        "neoforgeIcon" to
            when {
                stonecutter.current.parsed >= "26.3" -> "iconFile"
                else -> "logoFile"
            },
    )
}

dependencies {
    implementation(libs.configbuilder)
    include(libs.configbuilder)
    val compatibilityRuntimeConfiguration =
        when {
            stonecutter.current.parsed >= "26.1" -> "localRuntime"
            else -> "modLocalRuntime"
        }

    if (mod.hasProp("compatibility.sodium")) {
        add(
            compatibilityRuntimeConfiguration,
            "maven.modrinth:sodium:mc${mod.minecraftVersion}-${mod.prop("compatibility.sodium")}-${mod.loader}",
        )
    }

    if (mod.hasProp("compatibility.iris")) {
        add(
            compatibilityRuntimeConfiguration,
            "maven.modrinth:iris:${mod.prop("compatibility.iris")}+${mod.minecraftVersion}-${mod.loader}",
        )
    }
}

repositories {
    mavenLocal()
    maven("https://maven.terraformersmc.com/")
    maven("https://maven.shedaniel.me/")
    maven("https://maven.meza.gg/releases/")
    maven("https://maven.maxhenkel.de/repository/public")
    maven("https://api.modrinth.com/maven")
}
