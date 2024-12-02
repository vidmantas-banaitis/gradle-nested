group = "org.example"
version = "1.0.0-SNAPSHOT"
plugins {
    id("p.group")
    id("org.owasp.dependencycheck")
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
}


subprojects {
    println("$name in main build.gradle.kts")
}