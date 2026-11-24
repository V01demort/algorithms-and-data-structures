# Algorithms and Data Structures

Java exercises covering algorithms and data structures.

## Assignments

| Assignment | Topics |
| --- | --- |
| [1 — Recursion](assignment-1-recursion/) | Factorial, Fibonacci, GCD, strings and arrays |
| [2 — Data structures](assignment-2-data-structures/) | Arrays, stacks and queues |
| [3 — Sorting and searching](assignment-3-sorting-searching/) | Bubble sort, merge sort, linear search |
| [4 — Graph algorithms](assignment-4-graph-algorithms/) | BFS, DFS and Dijkstra |

## Run

Requires JDK 17 or later. Open an assignment in IntelliJ IDEA or compile it separately:

```bash
cd assignment-3-sorting-searching
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

Entry points:

- Assignment 1: `Task1`–`Task10`
- Assignment 2: `BankingSystem`, `Task6`
- Assignments 3 and 4: `Main`

The banking demo uses integer menu input (4 to exit). Dijkstra assumes non-negative edge weights. The examples use small inputs and fixed-size arrays where applicable; timings are illustrative.

Based on my coursework, with minor fixes and cleanup.
