plugins {
    kotlin("jvm") version "2.2.21"
}

group = "dev.jmoicano"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

kotlin {
    jvmToolchain(18)
}

tasks.test {
    useJUnitPlatform()
}