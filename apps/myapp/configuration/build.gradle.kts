println("configuration in build.gradle.kts")
plugins{
    id("p.java")
    id("p.spring")
    id("org.springframework.boot")
}

dependencies{
    implementation(project(":apps:myapp:core"))
    implementation(project(":apps:myapp:adapters:a-adapter"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
}