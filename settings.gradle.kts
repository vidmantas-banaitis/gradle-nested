rootProject.name = "gradle-nested"

fun recursiveInclude(parent:String, dir: File) {
    dir.listFiles().forEach {
        if (it.isDirectory && it.resolve(".p").exists()) {
//            val p = it.resolve(".p")
            println("found: ${it.name}")
            if (parent != "") {
                println("including: $parent:${it.name}")
                include("$parent:${it.name}")
            } else {
                println("including: ${it.name}")
                include(it.name)
            }
            recursiveInclude("$parent:${it.name}",it)
        }
    }
}

recursiveInclude(":", rootDir)