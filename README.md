# Gordle 🟩🟨⬛

[![CI](https://github.com/jmoicano/gordle/actions/workflows/ci.yml/badge.svg)](https://github.com/SEU_USUARIO/gordle/actions/workflows/ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.jmoicano/gordle-engine)](https://central.sonatype.com/artifact/io.github.jmoicano/gordle-engine)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)

**Gordle** is an open-source, modular toolkit for building Wordle-like word games on Android.

It provides a reusable game engine and customizable UI components, allowing developers to create their own word games with full control over rules, visuals, and dictionaries.

---

## What is Gordle?

Gordle is **not a game**.

It is a **foundation** for developers who want to build their own Wordle-style applications without reinventing the wheel.

With Gordle, you can:
- Define your own word lists and dictionaries
- Customize colors, shapes, typography, and animations
- Control game rules (word length, attempts, validation logic)
- Focus on your app’s experience, not low-level logic

---

## Goals

- Be fully modular and extensible
- Offer highly customizable UI components
- Keep game logic independent from Android
- Be easy to integrate into any Android project
- Be well-documented and beginner-friendly

---

## Architecture

Gordle is organized as a **multi-module project**:
```
gordle/
  ├── gordle-engine # Pure Kotlin game logic
  ├── gordle-ui-compose # Jetpack Compose UI components
  └── sample-app # Example application
```
### Key principles
- The engine contains **no Android dependencies**
- UI modules contain **no game rules**
- All state is controlled by the consumer application

---

## Getting Started

> Gordle is currently under development.

In the future, you will be able to add Gordle via Gradle:

```kotlin
dependencies {
    implementation("dev.jmoicano:gordle-engine:x.y.z")
    implementation("dev.jmoicano:gordle-ui-compose:x.y.z")
}
```
---

## Customization

Gordle UI components are fully customizable:

 - Colors for each letter state
 - Shapes and typography
 - Animations and transitions

Customization is done via theme and style objects provided by the consumer app.

---

## Sample App

The repository includes a sample-app module demonstrating:

 - Basic game implementation
 - Custom color themes
 - Integration with a custom dictionary

---

## Modules

| Module | Description |
| ------ | ----------- |
| `gordle-engine` |	Core game logic and word validation |
| `gordle-ui-compose` | Reusable Jetpack Compose components |
| `sample-app` | Demo application |

--- 

## Roadmap

 - [ ] Core engine API
 - [ ] Word validation abstraction
 - [ ] Compose UI components
 - [ ] Theming system
 - [ ] Sample app
 - [ ] Maven Central publishing
 - [ ] Compose Multiplatform support

---

## 🤝 Contributing

Contributions are welcome!
Please read the [CONTRIBUTING.md](CONTRIBUTING.md) before submitting pull requests.

---

## 📄 License

This project is licensed under the Apache License 2.0.
