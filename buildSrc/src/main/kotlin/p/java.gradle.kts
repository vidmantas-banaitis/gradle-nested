package p

plugins {
    `java-library`
}

repositories {
    mavenLocal()
    mavenCentral()
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
    withSourcesJar()
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