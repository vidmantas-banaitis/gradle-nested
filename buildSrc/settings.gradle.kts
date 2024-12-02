
pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    plugins {
        id("org.springframework.boot") version "3.4.0"
    }
}

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}