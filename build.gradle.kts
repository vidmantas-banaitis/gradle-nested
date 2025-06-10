group = "org.example"
version = "1.0.0-SNAPSHOT"

plugins {
    id("p.dependencies")
    id("jacoco-report-aggregation")
}

buildscript {
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
    afterEvaluate {
        if (plugins.hasPlugin("jacoco")) {
            rootProject.dependencies { jacocoAggregation(project) }
        }
    }
}

reporting {
    reports {
        val testCodeCoverageReport by creating(JacocoCoverageReport::class) {
            testSuiteName = "test"
        }
    }
}

