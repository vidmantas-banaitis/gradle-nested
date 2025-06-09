plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("io.spring.gradle:dependency-management-plugin:1.1.4")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.4.0")
}