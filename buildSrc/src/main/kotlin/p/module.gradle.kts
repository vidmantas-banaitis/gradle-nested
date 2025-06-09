package p

plugins{
    id("p.java")
    id("p.jacoco")
//    id("p.checkstyle")
    id("p.dependencies")
}


dependencies {
    api("org.slf4j:slf4j-api")

    runtimeOnly("ch.qos.logback:logback-classic")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}