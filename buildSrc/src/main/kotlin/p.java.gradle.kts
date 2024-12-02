import org.gradle.kotlin.dsl.jacoco

plugins {
    `java-library`
    jacoco
    checkstyle
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
    options.compilerArgs.addAll(
        listOf(
//            "-Xlint:unchecked",
//            "-Xlint:deprecation",
//            "-Xlint:rawtypes",
//            "-Xlint:fallthrough",
//            "-Xlint:finally",
            "-parameters"
        )
    )
}

tasks.withType<Test>() {
    useJUnitPlatform()
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}