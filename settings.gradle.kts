rootProject.name = "gradle-nested"

fun resolveProject(modulePath: String) {
    include(modulePath)

    // enhance module based on key in ".p" file
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
