rootProject.name = "gradle-nested"

fun resolveModule(modulePath: String) {
    println("including: $modulePath")
    include(modulePath)

    project(modulePath).apply {
        val extend = mutableListOf({})
        val config = file("$projectDir/.p")
        config.useLines { lines ->
            lines.forEach { line ->
                println("  $line")
                when (line) {
                    "group" -> {
                        extend.add { }
                        // TODO: configuration or extension to project to be used in build.gradle.kts
                        // TODO: group = "${parent!!.group}.${name}"
                    }

                    "java" -> {
                        extend.add { }
                        // TODO: configuration or extension to project to be used in build.gradle.kts
                        // TODO:
                        // apply(plugin = "java")
                        // apply(plugin = "io.spring.dependency-management")
                        // repositories {
                        //     mavenCentral()
                        // }
                        // dependencyManagement {
                        //     imports {
                        //         mavenBom("org.springframework.boot:spring-boot-dependencies:3.3.3") // extract to "versions.springBoot"
                        //         mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.3") // extract to "versions.springCloud"
                        //     }
                        // }
                        // version = parent!!.version
                    }

                    "spring" -> {
                        extend.add { }
                        // TODO: configuration or extension to project to be used in build.gradle.kts
                        // TODO:
                        // dependencies {
                        //     implementation("org.springframework:spring-core")
                        // }
                    }

                    "springboot" -> {
                        extend.add { }
                        // TODO: configuration or extension to project to be used in build.gradle.kts
                        // TODO:
                        // apply(plugin = "org.springframework.boot")
                        // dependencies {
                        //     implementation("org.springframework.boot:spring-boot-starter-web")
                        // }
                    }

                }
            }
        }

        extra["extend"] = extend
    }
}

fun recursiveInclude(prefix: String, dir: File) {
    dir.listFiles().forEach {
        if (it.isDirectory && it.resolve(".p").exists()) {
            val modulePath = "$prefix${it.name}"

            resolveModule(modulePath)

            recursiveInclude("$modulePath:", it)
        }
    }
}

recursiveInclude(":", rootDir)
