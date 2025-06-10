package p

plugins {
    id("io.spring.dependency-management")
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencyManagement {
    dependencies{
//        dependency("org.slf4j:slf4j-api:1.7.36")
//        dependency("ch.qos.logback:logback-classic:1.5.18")
    }
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.4.0")
    }
}
