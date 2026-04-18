# Code Style Guidelines

## Documentation
- Prefer Markdown-style Javadoc comments using the `///` syntax instead of the traditional `/** ... */` block comments.
- All new methods and classes should use this style.
- When refactoring existing code, update comments to use the `///` style.
- Use British English in all comments and documentation (e.g., "colour" instead of "color", "behaviour" instead of "behavior").

## Testing
- Test methods should not be prefixed with `test`. The `@Test` annotation is sufficient.
- Use descriptive names that explain what the test verifies (e.g., `printNormalLogo` instead of `testPrintNormalLogo`).
- Use British English in test names and descriptions.
