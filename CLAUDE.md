# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

- Build: `mvn clean compile`
- Run all tests: `mvn clean test`
- Run a single test: `mvn test -Dtest=ClassName` (e.g., `mvn test -Dtest=us.inest.epi.array.AsteroidCollisionTest`)

## Architecture and Structure

The repository is a collection of Java-based algorithm problems and technical exercises, organized primarily by their source or category:

- `src/main/us/inest/`:
    - `epi/`: Problems from "Elements of Programming Interviews", further divided by topic (array, dp, graph, etc.).
    - `lc150/`: LeetCode Top 150 problems, divided by topic (array, backtracking, bfs, etc.).
    - `lc75/`: LeetCode 75 problems.
    - `meta/`, `google/`, `dropbox/`: Company-specific problem sets.
    - `kafka/`: Kafka-related examples and instructions.
    - `tdd/`: Test-Driven Development exercises.
    - `utils/`: Common utility classes and data structure definitions (e.g., `ListNode`, `TreeNode`, `Graph`) used across various problems.

- `src/test/us/inest/`: Contains unit tests mirroring the structure of the main source code.

The project uses Maven for dependency management and builds, targeting Java 21.
