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
//    implementation(libs.spring.boot.gradle.plugin)
//    implementation(libs.slf4jApi)
}