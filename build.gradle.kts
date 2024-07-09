plugins {
    kotlin("jvm")
    id("io.gitlab.arturbosch.detekt")
}

group = project.name
version = extra["$group.version"] as String

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}
