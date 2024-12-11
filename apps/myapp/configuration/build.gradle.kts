println("configuration in build.gradle.kts")
plugins{
    id("p.java")
    id("p.spring")
    id("p.springboot")
}

dependencies{
    implementation(project(":apps:myapp:core"))
    implementation(project(":apps:myapp:adapters:a-adapter"))
}