println("a-adapter in build.gradle.kts")
plugins{
    id("p.java")
    id("p.spring")
}
dependencies{
    implementation(project(":clients:client-a"))
    implementation(project(":apps:myapp:core"))
}