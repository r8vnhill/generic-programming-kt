import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupBoundsModule") {
    description = "Creates the base module and files for the bounds lesson"
    module.set("bounds")

    doLast {
        createFiles(
            "repo",
            main to "Repository.kt",
            main to "Entity.kt",
            main to "Serializable.kt",
            test to "RepositoryTest.kt"
        )
        createFiles(
            "notifications",
            main to "EmailNotificationSystem.kt",
            main to "NotificationHandler.kt",
            main to "Notification.kt",
            test to "NotificationSystemTest.kt"
        )
    }
}
