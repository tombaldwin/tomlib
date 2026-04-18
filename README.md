# tomlib

<p align="center">
  <img src="docs/images/logo.svg" width="200" alt="tomlib Logo">
</p>

A common library for multiple projects, hosted on GitHub at [tombaldwin/tomlib](https://github.com/tombaldwin/tomlib).

## Overview

This project contains common library code used across various projects by Tom Baldwin.

## Visual Documentation
- [**Themes**](THEMES.md)
- [**Mascots**](MASCOTS.md)
- [**Fonts**](FONTS.md)

## Usage (JitPack)

This library is published to JitPack.

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
   *Replace `v1.0.0` with the latest release tag.*

## Alternatives

### GitHub Packages
If you prefer GitHub Packages, you can still use it by adding:
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

dependencies {
    implementation("io.poly:tomlib:1.0-SNAPSHOT")
}
```
*Note: GitHub Packages requires authentication.*
