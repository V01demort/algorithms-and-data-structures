# Algorithms and Data Structures

Java coursework completed at Astana IT University (2026).

## Assignments

| Assignment | Topics | Entry point |
|---|---|---|
| [1 — Recursion](assignment-1-recursion/) | Digits, array average, primality, factorial, Fibonacci, power, reverse traversal, digit check, string length, GCD | `Task1`–`Task10` |
| [2 — Data structures](assignment-2-data-structures/) | Array-based banking demo, transaction stack and request/bill queues | `BankingSystem`, `Task6` |
| [3 — Sorting and searching](assignment-3-sorting-searching/) | Bubble sort, merge sort, linear search and timing experiments | `Main` |
| [4 — Graph algorithms](assignment-4-graph-algorithms/) | Directed weighted graphs, BFS, DFS, Dijkstra and timing experiments | `Main` |

## Running the examples

Requires JDK 17 or later. Open an assignment folder in IntelliJ IDEA and run the corresponding class, or use the terminal. Compile each assignment separately because assignments 3 and 4 have classes with identical names.

```sh
cd assignment-3-sorting-searching
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

For assignment 1, run `java -cp out Task1` (or another task number). For assignment 2, run `java -cp out BankingSystem` or `java -cp out Task6`. The banking demo accepts integer menu input; select 4 in the main menu to exit.

## Notes

This repository is based on my original university coursework. For portfolio publication, the recursion snippets were wrapped in named Java classes, one duplicate draft was omitted, and small correctness and input-boundary fixes were made. The original algorithms and console demonstrations are retained.

The banking example is an educational, in-memory simulation with fixed-size arrays, not a production banking system. The graph example uses fixed-size arrays and non-negative integer edge weights. Timing measurements are illustrative single runs, not rigorous benchmarks; graph traversal timings include console output. The recursion exercises use small demonstration inputs.
