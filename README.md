# Java Algorithm & Engineering Practice

A comprehensive collection of Java implementations for algorithm problems, technical interview preparation, and software engineering exercises.

## 🚀 Project Overview

This repository serves as a structured study guide and implementation library for various competitive programming and interview questions. It targets **Java 21** and uses **Maven** for build and dependency management.

## 📂 Repository Structure

The codebase is organized by source and topic under `src/main/us/inest/`:

### 🧠 Algorithm Problems
- **`epi/`**: Implementations from *Elements of Programming Interviews*, categorized by data structure and technique (e.g., Array, DP, Graph, Heap, Stack).
- **`lc150/`**: LeetCode Top Interview 150 problems, organized by topic (e.g., BFS, DFS, Sliding Window, Two Pointers).
- **`lc75/`**: LeetCode 75 essential problems.
- **Company-Specific**: Specialized problem sets for `meta/`, `google/`, and `dropbox/`.

### 🛠️ Engineering & Tools
- **`kafka/`**: Practical examples of Kafka producers and consumers.
- **`tdd/`**: Exercises focusing on Test-Driven Development.
- **`utils/`**: Shared utility classes and common data structure definitions (e.g., `ListNode`, `TreeNode`, `Graph`) to avoid redundancy across problems.

## 🧪 Testing

Many implementations are accompanied by unit tests located in `src/test/us/inest/`, ensuring correctness through JUnit.

## 🛠️ Getting Started

### Prerequisites
- JDK 21
- Maven

### Build & Test
To compile the project:
```bash
mvn clean compile
```

To run all tests:
```bash
mvn clean test
```

To run a specific test class:
```bash
mvn test -Dtest=ClassName
```
*(Replace `ClassName` with the fully qualified name, e.g., `us.inest.epi.array.AsteroidCollisionTest`)*
