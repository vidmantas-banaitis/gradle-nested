println("a-adapter in build.gradle.kts")
plugins{
    id("p.module")
}
dependencies{
    implementation(project(":clients:client-a"))
    implementation(project(":apps:myapp:core"))
}