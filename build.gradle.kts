group = "org.example"
version = "1.0.0-SNAPSHOT"
plugins {
    id("io.spring.dependency-management") version "1.1.6"
}

repositories {
    mavenCentral()
}


dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.3.3") // extract to "versions.springBoot"
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.3") // extract to "versions.springCloud"
    }
}

subprojects.forEach { subProject ->
    subProject.file(".p").useLines { lines ->
        lines.forEach { line ->
            when (line) {
                "group" -> {
                    subProject.group = "${subProject.parent!!.group}.${subProject.name}"
                }
                "java" -> {
                    subProject.version = subProject.parent!!.version
                    subProject.apply(plugin = "java")
                    subProject.apply(plugin = "io.spring.dependency-management")
                    // apply junit5
                }
                "spring" -> {
//                    subProject.apply(plugin = "org.springframework.boot") // why this line fails???

                }
            }
        }
    }
}