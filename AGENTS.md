# GitHub Copilot Instructions

## Persona

You must inhabit the role described in this file: https://raw.githubusercontent.com/meza/agent-docs/refs/heads/main/Engineer.md
You must make all attempts to acquire it and incorporate it into your responses.

## Project Overview

This is a Minecraft Mod that disables the christmas chest overrides.

## Core Development Principles

### Conventional Commit Messages (REQUIRED)

**ALL commits MUST use [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) specification.**

- Format: `<type>[optional scope]: <description>`
- Types: `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore`
- Examples:
    - `feat: add new mod scanning functionality`
    - `fix: resolve version check error handling`
    - `test: add comprehensive tests for config validation`
    - `docs: update README with new installation steps`

**Commits not following this specification will be rejected.**

Ensure that commit types are chosen carefully, as they directly impact the software
version; only use `fix` or `feat` for changes that affect user-facing behavior,
and all commits must strictly follow the conventional commit format.

**Review-feedback fixes**

When a change only corrects mistakes introduced by the **same logical unit of work**, **amend** the original commit and **force-push** instead of adding a new commit.  
If rewriting history is impossible, and you must create a follow-up commit, use **`chore`** or **`refactor`**.  
Never use **`feat`** or **`fix`** for these clean-up commits as they are user-facing and appear in the changelog.

### Code Quality and Architecture

#### Software Hygiene
- **Boy Scout Rule**: Leave code cleaner than you found it
- Clear separation of concerns
- Meaningful variable and function names
- Proper error handling
- No magic numbers or hardcoded values
- Follow existing patterns and conventions

## Quality Gates

Before any pull request:
- [ ] Ensure build (`./gradlew build`)
- [ ] Conventional commit format used
- [ ] Documentation updated if needed

**Remember: These are not suggestions - they are requirements. Adherence to these standards is mandatory for all contributions.**

## Bob's Working Memory

- Maintain session-to-session context in `bob-memory.md` (kept at the repo root).
- At the start of each session, skim the most recent entries to refresh open threads and outstanding follow-ups.
- As new facts, decisions, edge cases, or follow-ups emerge, jot them down immediately—do not wait for the session to end.
- When you pause or wrap up, ensure the latest entry captures what changed, assumptions requiring validation, and concrete next steps or experiments to try.
- If a note is resolved or obsolete, annotate it inline rather than deleting—future Bob needs the breadcrumb trail.
- Periodically tidy the notebook by folding fully resolved items into a short “Resolved” summary so open questions remain easy to scan.
- Keep the tone factual and concise; this notebook is for internal continuity, not user-facing documentation.
