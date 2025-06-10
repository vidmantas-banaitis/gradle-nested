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
        val rootCodeCoverageReport by creating(JacocoCoverageReport::class) {
            testSuiteName = "test"
        }
    }
}

tasks.named<JacocoReport>("rootCodeCoverageReport") {
    subprojects {
        if (plugins.hasPlugin("jacoco")) {
            dependsOn(tasks.named<JacocoReport>("jacocoTestReport"))
        }
    }
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

tasks.register("clean") {
    group = "build"
    description = "Clean tests build"
    delete(project.layout.buildDirectory)
}

tasks.register("check") {
    group = "verification"
    description = "Run all checks including tests and code coverage"
    dependsOn(tasks.named("rootCodeCoverageReport"))
}

tasks.register("build") {
    group = "build"
    description = "Build the project including all subprojects"
    dependsOn(tasks.named("check"))
}

