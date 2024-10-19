tasks.register("setupBoundsModule") {
    val baseDir = "bounds"
    doLast {
        // Crear el archivo build.gradle.kts si no existe
        createFileIfNotExists(rootProject.file(baseDir), "build.gradle.kts", "// Intentionally left blank")

        // Crear archivos en el paquete "repo"
        val groupPath = rootProject.group.toString().replace(".", "/")
        val repoFiles = listOf(
            "main" to "Repository.kt", "main" to "Entity.kt", "main" to "Serializable.kt",
            "test" to "RepositoryTest.kt"
        )
        createFilesForPackage(baseDir, groupPath, "repo", repoFiles)

        // Crear archivos en el paquete "notifications"
        val notificationFiles = listOf(
            "main" to "EmailNotificationSystem.kt", "main" to "NotificationHandler.kt",
            "main" to "Notification.kt", "test" to "NotificationSystemTest.kt"
        )
        createFilesForPackage(baseDir, groupPath, "notifications", notificationFiles)
    }
}

// Función para crear un archivo si no existe
fun createFileIfNotExists(dir: File, fileName: String, content: String) {
    dir.apply { mkdirs() }
        .resolve(fileName).apply {
            if (!exists()) {
                writeText(content)
                println("File created: $this")
            } else {
                println("File already exists: $this")
            }
        }
}

// Función para crear múltiples archivos en un paquete
fun createFilesForPackage(
    baseDir: String, groupPath: String, packageName: String,
    files: List<Pair<String, String>>
) {
    files.forEach { (type, fileName) ->
        val dir = rootProject.file("$baseDir/src/$type/kotlin/$groupPath/$packageName")
            .apply { mkdirs() }
        createFileIfNotExists(dir, fileName, "package ${rootProject.group}.$packageName\n\n")
    }
}
