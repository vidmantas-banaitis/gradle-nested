package p

plugins {
    `java-library`
}

repositories {
    mavenLocal()
    mavenCentral()
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
    withSourcesJar()
}

dependencies {
    api("org.slf4j:slf4j-api")


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