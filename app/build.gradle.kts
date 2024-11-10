plugins {
    id("org.springframework.boot") version "3.3.5"
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.spring") version "2.0.21"
    kotlin("plugin.jpa") version "2.0.21"
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

allprojects {
    apply {plugin("io.spring.dependency-management" )}
    group = "org.example"
    version = "1.0-SNAPSHOT"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.micrometer:micrometer-registry-prometheus:latest.release")
}