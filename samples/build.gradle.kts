plugins {
    id("java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":"))
    implementation(libs.bundles.log4j)
}
