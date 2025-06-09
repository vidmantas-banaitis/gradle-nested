package p
plugins {
    `java-library`
    id("p.java")
    id("io.spring.dependency-management")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.2.6")
    }
}
