import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupIntroModule") {
    description = "Creates the base module and files for the intro lesson"
    module.set("intro")

    doLast {
        createFiles(
            "id",
            main to "Identity.kt",
            test to "IdentityTest.kt"
        )
        createFiles(
            "box",
            main to "Box.kt",
            test to "BoxTest.kt"
        )
        createFiles(
            "repo",
            main to "Repository.kt",
            main to "User.kt",
            main to "UserRepository.kt",
            test to "UserRepositoryTest.kt"
        )
    }
}
