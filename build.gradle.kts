group = "org.example"
version = "1.0.0-SNAPSHOT"
plugins {
    id("io.spring.dependency-management") version "1.1.6"
//    id("org.springframework.boot") version "3.3.3" apply false
}
dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.3.3") // extract to "versions.springBoot"
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.3") // extract to "versions.springCloud"
    }
}
subprojects {
    println("$name in main build.gradle.kts")
    file(".p").useLines { lines ->
        lines.forEach { line ->
            when (line) {
                "group" -> {
                    group = "${parent!!.group}.${name}"
                }

                "java" -> {
                    apply(plugin = "java")
                    apply(plugin = "io.spring.dependency-management")

                    repositories {
                        mavenCentral()
                    }
                    dependencyManagement {
                        imports {
                            mavenBom("org.springframework.boot:spring-boot-dependencies:3.3.3") // extract to "versions.springBoot"
                            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.3") // extract to "versions.springCloud"
                        }
                    }
                    version = parent!!.version
                }

                "spring" -> {

                }

                "springboot" -> {
//                    apply(plugin = "org.springframework.boot") // why this line fails???
//                    apply(group="org.springframework.boot", name="org.springframework.boot", version="3.3.3")
                }
            }
        }
    }
}