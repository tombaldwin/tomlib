plugins {
    id("java-library")
    id("maven-publish")
    id("idea")
}

group = "io.poly"
version = "1.0-SNAPSHOT"

if (project.hasProperty("group")) {
    project.group = project.property("group")?.toString() ?: "io.poly"
}
if (project.hasProperty("version")) {
    project.version = project.property("version")?.toString() ?: "1.0-SNAPSHOT"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.log4j)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = "tomlib"
            version = project.version.toString()
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
