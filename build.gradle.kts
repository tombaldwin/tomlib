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

tasks.register<JavaExec>("generateDocs") {
    group = "documentation"
    description = "Generates documentation with examples of themes, mascots, and fonts."
    classpath = sourceSets["test"].runtimeClasspath
    mainClass.set("io.poly.tomlib.util.DocumentationGenerator")
    dependsOn("copyLogo")
}

tasks.register<Copy>("copyLogo") {
    group = "documentation"
    description = "Copies the tomlib logo to standard locations (docs and .idea)."
    from("src/main/resources/logos/tomlib_logo.svg")
    into("docs/images")
    rename { "logo.svg" }

    doLast {
        copy {
            from("src/main/resources/logos/tomlib_logo.svg")
            into(".idea")
            rename { "icon.svg" }
        }
    }
}
