package p

plugins {
    `java-library`
    id("org.springframework.boot")

}
repositories {
    mavenLocal()
    mavenCentral()
}
apply(plugin = "io.spring.dependency-management")

