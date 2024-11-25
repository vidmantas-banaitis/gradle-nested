println("a-adapter in build.gradle.kts")
dependencies{
    implementation(project(":clients:client-a"))
    implementation(project(":apps:myapp:core"))
}