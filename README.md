# tomlib

A common library for multiple projects, hosted on GitHub at [tombaldwin/tomlib](https://github.com/tombaldwin/tomlib).

## Overview

This project contains common library code used across various projects by Tom Baldwin.

## Usage

### Option 1: JitPack (Easiest)

JitPack allows you to use any GitHub repository as a Maven repository.

1. Add the JitPack repository to your `build.gradle.kts`:
   ```kotlin
   repositories {
       maven { url = uri("https://jitpack.io") }
   }
   ```
2. Add the dependency:
   ```kotlin
   dependencies {
       implementation("com.github.tombaldwin:tomlib:v1.0.0")
   }
   ```
   *Note: Use `com.github.user:repo:tag` format with JitPack.*

### Option 2: GitHub Packages

You can also publish to GitHub Packages for a more formal Maven repository.

1. Add the following to your `build.gradle.kts`:
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

To publish to GitHub Packages, you can use the `maven-publish` plugin already configured in this project. 

### Manual Publishing
Run:
```bash
./gradlew publish
```
You will need to provide `GITHUB_ACTOR` and `GITHUB_TOKEN` environment variables.

### Automatic Publishing (GitHub Actions)
Create a file at `.github/workflows/publish.yml`:
```yaml
name: Publish Package
on:
  release:
    types: [created]
jobs:
  publish:
    runs-on: ubuntu-latest
    permissions:
      contents: read
      packages: write
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Publish with Gradle
        run: ./gradlew publish
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
```
