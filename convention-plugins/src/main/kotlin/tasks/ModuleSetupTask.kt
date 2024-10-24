package tasks

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File

private val printError: (String) -> Unit = System.err::println

abstract class ModuleSetupTask : DefaultTask() {

    @get:Input
    abstract val module: Property<String>

    private val baseDir: File
        get() = project.rootProject.file(module)

    init {
        group = "setup"
    }

    @TaskAction
    fun setupSubmodule() {
        createSettingsFile()
        createModuleDirectory()
        createBuildFile()
    }

    private fun createSettingsFile() {
        val settingsFile = project.file("settings.gradle.kts")
        if (!settingsFile.exists()) {
            settingsFile.writeText("rootProject.name = \"${project.name}\"\n")
            settingsFile.writeText("include(\"${module.get()}\")")
        } else if (module.get() !in settingsFile.readText()) {
            settingsFile.appendText("\ninclude(\"${module.get()}\")")
        }
    }


    private fun createModuleDirectory() = baseDir.run {
        when {
            exists() -> printError("Directory already exists: $absolutePath")
            mkdirs() -> println("Directory created: $absolutePath")
            else -> printError("Failed to create directory: $absolutePath")
        }
    }

    private fun createBuildFile() = baseDir.resolve("build.gradle.kts").run {
        if (exists()) printError("The build file already exists")
        else writeText("// Intentionally left blank\n")
    }
}
