import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupBoundsModule") {
    description = "Creates the base module and files for the generic bounds lesson"
    module.set("bounds")
}
