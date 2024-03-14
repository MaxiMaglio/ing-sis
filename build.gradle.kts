plugins {
    kotlin("jvm") version "1.8.10"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.10")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.8.10")
}

tasks.test {
    useJUnit()
}
