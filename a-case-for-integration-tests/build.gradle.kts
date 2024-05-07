plugins {
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

extra["springCloudVersion"] = "2023.0.1"

repositories {
    mavenCentral()
}

sourceSets {
    create("itest") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
}

val itestImplementation by configurations.getting {
    extendsFrom(configurations.implementation.get())
}
val itestRuntimeOnly by configurations.getting

configurations["itestRuntimeOnly"].extendsFrom(configurations.runtimeOnly.get())

val itest = task<Test>("itest") {
    description = "Runs integration tests."
    group = "verification"

    testClassesDirs = sourceSets["itest"].output.classesDirs
    classpath = sourceSets["itest"].runtimeClasspath
    shouldRunAfter("test")

    useJUnitPlatform()

    testLogging {
        events("passed")
    }
}

tasks.check { dependsOn(itest) }

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

dependencies {
    implementation(libs.org.springframework.boot.spring.boot.starter.web)
    itestImplementation(libs.org.springframework.cloud.spring.cloud.starter.contract.stub.runner)
    itestImplementation(libs.org.springframework.boot.spring.boot.starter.test)
    itestImplementation(libs.io.rest.assured.rest.assured)

}

group = "com.coderstower.blog"
version = "0.0.1-SNAPSHOT"
description = "a-case-for-integration-tests"

java {
    sourceCompatibility = JavaVersion.VERSION_22
}

tasks.withType<Test> {
    useJUnitPlatform()
}

