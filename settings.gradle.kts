rootProject.name = "gradle-nested"

fun resolveModule(modulePath: String) {
    println("including: $modulePath")
    include(modulePath)
}

fun recursiveInclude(prefix: String, dir: File) {
    dir.listFiles().forEach {
        if (it.isDirectory && !it.name.equals("buildSrc") && it.resolve("build.gradle.kts").exists()) {
            val modulePath = "$prefix${it.name}"

            resolveModule(modulePath)

            recursiveInclude("$modulePath:", it)
        }
    }
}

recursiveInclude(":", rootDir)
