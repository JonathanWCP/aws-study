plugins {
    kotlin("plugin.spring") version "2.0.21"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation(project(":aws-study-infrastructure", "default"))
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    mainClass.set("com.library.Main")
}