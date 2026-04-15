# tomlib

A common library for multiple projects, hosted on GitHub at [tombaldwin/tomlib](https://github.com/tombaldwin/tomlib).

## Overview

This project contains common library code used across various projects by Tom Baldwin.

## Usage (GitHub Packages)

This library is published to GitHub Packages.

1. Add the GitHub Packages repository to your `build.gradle.kts`:
   ```kotlin
   repositories {
       maven {
           name = "GitHubPackages"
           url = uri("https://maven.pkg.github.com/tombaldwin/tomlib")
           credentials {
               username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
               password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
           }
       }
   }
   ```
2. Add the dependency:
   ```kotlin
   dependencies {
       implementation("io.poly:tomlib:1.0-SNAPSHOT")
   }
   ```

## Publishing

To publish to GitHub Packages, use the `maven-publish` plugin already configured in this project.

### Automatic Publishing (GitHub Actions)
The library is automatically published to GitHub Packages when a new release is created via GitHub.
- See `.github/workflows/publish.yml` for the configuration.

### Manual Publishing
Run:
```bash
./gradlew publish
```
You will need to provide `GITHUB_ACTOR` and `GITHUB_TOKEN` environment variables (or set them in `gradle.properties` as `gpr.user` and `gpr.key`).

## Alternatives

### JitPack
If you prefer JitPack, you can still use it by adding:
```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.tombaldwin:tomlib:v1.0.0")
}
```
