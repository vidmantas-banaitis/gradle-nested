println("configuration in build.gradle.kts")
plugins{
    id("application")
}

dependencies{
    implementation(project(":apps:myapp:core"))
    implementation(project(":apps:myapp:adapters:a-adapter"))
}