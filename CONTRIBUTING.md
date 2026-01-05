# Contributing to Gordle

Thank you for your interest in contributing to **Gordle** 🎉  
Contributions of all kinds are welcome: bug reports, feature requests, documentation improvements, and code.

This document outlines the guidelines to help keep the project consistent, maintainable, and welcoming.

---

## Project Philosophy

Before contributing, please keep in mind the core principles of Gordle:

- **Clear separation of concerns**
- **Game logic must remain UI-agnostic**
- **UI components must not contain game rules**
- **Public APIs should be simple and stable**
- **Customization over configuration**

If a contribution conflicts with these principles, it may not be accepted.

---

## Project Structure

Gordle is organized into multiple modules:

- `gordle-engine`  
  Core game logic (pure Kotlin, no Android dependencies)

- `gordle-ui-compose`  
  Jetpack Compose UI components (no game logic)

- `sample-app`  
  Example application (not part of the public API)

Please make sure your changes affect the correct module.

---

## Reporting Bugs

If you find a bug, please open an issue and include:

- A clear description of the problem
- Steps to reproduce
- Expected vs actual behavior
- Screenshots or logs (if applicable)
- Module affected (`engine`, `ui-compose`, etc.)

Before opening a new issue, check if it has already been reported.

---

## Suggesting Features

Feature requests are welcome!

When suggesting a feature:
- Explain **what problem it solves**
- Describe **how it fits Gordle’s goals**
- Indicate which module it affects
- Be open to discussion and iteration

Note: Large or architectural changes should be discussed in an issue **before** submitting a pull request.

---

## Development Setup

### Requirements
- Android Studio (latest stable)
- JDK 17
- Gradle (included via wrapper)

### Build the project
```bash
./gradlew build
```
### Run tests
```bash
./gradlew test
```

---

## Testing Guidelines

- All logic in `gordle-engine` must be covered by unit tests
- New features should include relevant tests
- UI modules should avoid complex logic that requires heavy testing
Pull requests that break existing tests will not be accepted.

---

## Coding Guidelines

- Follow Kotlin official style guidelines
- Prefer immutability and explicit state
- Avoid unnecessary abstractions
- Keep public APIs minimal and well-documented
- Use meaningful names for classes and functions

### Public API changes

If your contribution changes a public API:
- Clearly document the change
- Explain the motivation
- Consider backward compatibility

---

## Pull Request Process

1. Fork the repository
2. Create a feature branch from
   ```bash
   git checkout -b feature/your-feature-name
3. Commit your changes with clear messages
4. Ensure all tests pass
5. Open a pull request against `main`

### Pull Request Checklist

 - [ ] Code builds successfully
 - [ ] Tests added or updated (if applicable)
 - [ ] Documentation updated (if needed)
 - [ ] Changes align with Gordle’s architecture

---

Documentation

Documentation improvements are highly appreciated.

Relevant files:

- `README.md`
- `docs/architecture.md`
- `docs/theming.md`
If behavior changes, documentation should be updated accordingly.

---

## 🤝 Code of Conduct

By contributing, you agree to follow a respectful and inclusive code of conduct.
Harassment, discrimination, or inappropriate behavior will not be tolerated.

---

## 📄 License

By contributing to Gordle, you agree that your contributions will be licensed under the Apache License 2.0, the same license as the project.

---

Thank you for helping make Gordle better!
