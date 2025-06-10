package p

plugins{
    id("p.java")
    id("p.jacoco")
//    id("p.checkstyle")
    id("p.dependencies")
}


dependencies {
    implementation("org.slf4j:slf4j-api")

    runtimeOnly("ch.qos.logback:logback-classic")

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}