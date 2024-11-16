plugins {
    kotlin("plugin.spring") version "2.0.21"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    //implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("software.amazon.awssdk:dynamodb:2.29.12")
    implementation("software.amazon.awssdk:dynamodb-enhanced:2.29.12")
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    mainClass.set("com.library.Main")
}
