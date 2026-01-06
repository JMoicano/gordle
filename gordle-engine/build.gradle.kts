plugins {
    kotlin("jvm") version "2.2.21"
    `maven-publish`
    signing
}

group = "io.github.jmoicano"
version = "0.1.0"

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

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Gordle Engine")
                description.set("A generic Wordle-like game engine.")
                url.set("https://github.com/jmoicano/gordle")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                developers {
                    developer {
                        id.set("jmoicano")
                        name.set("João Mário Soares Silva")
                        email.set("jmariossilva@gmail.com")
                    }
                }

                scm {
                    url.set("https://github.com/jmoicano/gordle")
                    connection.set("scm:git:https://github.com/jmoicano/gordle.git")
                    developerConnection.set("scm:git:ssh://git@github.com:jmoicano/gordle.git")
                }
            }
        }
    }
}

signing {
    isRequired = System.getenv("CI") == "true"

    useInMemoryPgpKeys(
        System.getenv("SIGNING_KEY"),
        System.getenv("SIGNING_PASSWORD")
    )
    sign(publishing.publications)
}