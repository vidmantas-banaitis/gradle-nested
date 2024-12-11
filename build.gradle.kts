group = "org.example"
version = "1.0.0-SNAPSHOT"
plugins {
    id("p.group")
//    alias(libs.plugins.springBoot) apply false
//    id("io.spring.dependency-management") version "1.1.6"
}


subprojects {
    println("$name in main build.gradle.kts")

}