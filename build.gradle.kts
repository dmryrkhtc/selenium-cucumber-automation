plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.yaml:snakeyaml:2.2")
        testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")

        testImplementation("io.cucumber:cucumber-java:7.15.0")
        testImplementation("io.cucumber:cucumber-junit-platform-engine:7.15.0")

        testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
        testImplementation("org.junit.platform:junit-platform-suite:1.10.0")
    }


tasks.test {
    useJUnitPlatform()
}