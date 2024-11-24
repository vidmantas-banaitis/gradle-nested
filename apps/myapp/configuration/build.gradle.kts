plugins{
    id("application")
}

dependencies{
    implementation(project(":apps:myapp:core"))
    implementation(project(":apps:myapp:adapters:a-adapter"))
}