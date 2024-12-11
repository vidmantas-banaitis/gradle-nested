plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.spring.boot.gradle.plugin)
    implementation(libs.slf4jApi)
}