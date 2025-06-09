rootProject.name = "gradle-nested"

pluginManagement {
    plugins {
        id("io.spring.dependency-management") version "1.1.6" apply false
        id("org.springframework.boot") version "3.4.0" apply false
    }
}

fun resolveModule(modulePath: String) {
    println("including: $modulePath")
    include(modulePath)
}

fun recursiveInclude(prefix: String, dir: File) {
    dir.listFiles()?.forEach {
        if (it.isDirectory && !it.name.equals("buildSrc") && it.resolve("build.gradle.kts").exists()) {
            val modulePath = "$prefix${it.name}"

            resolveModule(modulePath)

            recursiveInclude("$modulePath:", it)
        }
    }
}

recursiveInclude(":", rootDir)
