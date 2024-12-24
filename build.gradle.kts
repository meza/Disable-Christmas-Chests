plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
}

val minecraftVersion = stonecutter.current.version

version = "${mod.version}+mc${minecraftVersion}"
base {
    archivesName.set("${mod.id}-common")
}

architectury.common(stonecutter.tree.branches.mapNotNull {
    if (stonecutter.current.project !in it) null
    else it.prop("loom.platform")
})

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings("net.fabricmc:yarn:${prop("yarn_mappings")}:v2")
    modImplementation("net.fabricmc:fabric-loader:${prop("loader_version")}")
}

loom {

    accessWidenerPath = rootProject.file("src/main/resources/disablechristmaschests.accesswidener")

    decompilers {
        get("vineflower").apply { // Adds names to lambdas - useful for mixins
            options.put("mark-corresponding-synthetics", "1")
        }
    }
}

java {
    withSourcesJar()
    val java = if (stonecutter.eval(minecraftVersion, ">=1.20.5"))
        JavaVersion.VERSION_21 else JavaVersion.VERSION_17
    targetCompatibility = java
    sourceCompatibility = java
}

tasks.processResources {
    val refmap = "refmap" to "${mod.id}-common-$minecraftVersion-refmap.json"
    inputs.properties(refmap)

    filesMatching("${mod.id}-client.mixins.json") {
        expand(refmap)
    }
}


tasks.build {
    group = "versioned"
    description = "Must run through 'chiseledBuild'"
}


tasks.register("configureMinecraft") {
    group = "project"
    val runDir = "${rootProject.projectDir}/run"
    val optionsFile = file("$runDir/options.txt")

    doFirst {

        println("Configuring Minecraft options...")

        // Ensure the run directory exi sts
        optionsFile.parentFile.mkdirs()

        // Write the desired options to 'options.txt'
        optionsFile.writeText(
            """
            guiScale:3
            fov=90
            narrator:0
            soundCategory_music:0.0
            darkMojangStudiosBackground:true
            """.trimIndent()
        )
    }
}

