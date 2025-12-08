import gg.meza.stonecraft.mod

plugins {
    id("gg.meza.stonecraft")
}

modSettings {
    clientOptions {
        darkBackground = true
        musicVolume = 0.0
        narrator = false
    }

    variableReplacements = mapOf(
        "schema" to "\$schema",
        "cloth_version" to mod.prop("cloth_version", "*"),
        "modmenu_version" to mod.prop("modmenu_version", "*"),
    )
}

repositories {
    mavenLocal()
    maven("https://maven.terraformersmc.com/")
    maven("https://maven.shedaniel.me/")
    maven("https://maven.meza.gg/releases/")
}
