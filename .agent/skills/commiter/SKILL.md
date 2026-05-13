---
name: committer
description: Use it when you're asked to create a commit
---

Use Conventional Commits for commit messages. Each message must follow this structure:

`<type>(<optional_scope>): <emoji> <description>`

### Types and associated Emojis:

- `feat`: ✨ for new features.
- `fix`: 🐛 for bug fixes.
- `docs`: 📝 for documentation changes.
- `style`: 🎨 for formatting changes (white-space, formatting, missing semi-colons, etc.) that do not affect the logic.
- `refactor`: ♻️ for code changes that neither fix a bug nor add a feature.
- `perf`: ⚡️ for performance improvements.
- `test`: ✅ for adding or updating tests.
- `build`: 👷 for changes in the build system or dependencies (e.g., Gradle).
- `ci`: 💚 for changes to CI configuration files and scripts.
- `chore`: 🔧 for routine maintenance tasks.
- `revert`: ⏪ for reverting a previous commit.

### Additional Rules:
1. The title must be concise.
2. Use the imperative mood in the description (e.g., "add" instead of "added").
3. If the change breaks compatibility (Breaking Change), add `!` after the type or `BREAKING CHANGE:` in the message body.
