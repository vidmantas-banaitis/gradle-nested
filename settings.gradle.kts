rootProject.name = "gradle-nested"

fun resolveProject(modulePath: String) {
    include(modulePath)

    project(modulePath).apply {
        file(".p").useLines { lines ->
            lines.forEach { line ->
                when (line) {
                    "group" -> {

                    }
                    "java" -> {
//                        apply(plugin = "java")
//                        apply(plugin = "io.spring.dependency-management")

                    }

                    "spring" -> {

                    }

                    "springboot" -> {
//                        apply(plugin = "org.springframework.boot") // why this line fails???
                    }

                }
            }
        }
    }
}

fun recursiveInclude(parent: String, dir: File) {
    dir.listFiles().forEach {
        if (it.isDirectory && it.resolve(".p").exists()) {
            println("including: $parent${it.name}")
            resolveProject("$parent${it.name}")

            recursiveInclude("$parent${it.name}:", it)
        }
    }
}

recursiveInclude(":", rootDir)
