group = "org.example"
version = "1.0.0-SNAPSHOT"
plugins {

//    alias(libs.plugins.springBoot) apply false
//    id("io.spring.dependency-management") version "1.1.6"
}


buildscript{
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("io.spring.gradle:dependency-management-plugin:1.1.6")
    }
}

subprojects {
    println("$name in main build.gradle.kts")

}