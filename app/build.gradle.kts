plugins {
    id("org.springframework.boot") version "3.3.5"
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.spring") version "2.0.21"
    //kotlin("plugin.jpa") version "2.0.21"
}

allprojects {
    repositories {
        mavenCentral()
        maven("https://repo.spring.io/snapshot")
        maven("https://repo.spring.io/milestone")
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "io.spring.dependency-management")
    group = "com.library"

    dependencies {
        implementation(kotlin("stdlib"))
    }

    tasks.test {
        useJUnitPlatform()
    }

    kotlin {
        jvmToolchain(17)
    }
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    mainClass.set("com.library.Main")
}
