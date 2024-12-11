package p
plugins {
    `java-library`

}
apply(plugin = "io.spring.dependency-management")


repositories {
    mavenLocal()
    mavenCentral()
}