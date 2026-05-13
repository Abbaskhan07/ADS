# Assignment 4: Graph Traversal and Representation System
# Ibraimov Abbaskhan IT-2501
## Project Overview
This project implements a graph data structure using an **Adjacency List** representation. It includes two main graph traversal algorithms: **Breadth-First Search (BFS)** and **Depth-First Search (DFS)**.

The program creates graphs of different sizes (10, 30, and 100 vertices), performs traversals, measures execution time using `System.nanoTime()`, and analyzes the performance.

**Key Features:**
- Object-Oriented Design with multiple classes
- Adjacency List representation
- BFS and DFS implementations
- Performance testing on different graph sizes
- Clean and well-structured Java code

## Class Descriptions

### Vertex Class
Represents a node in the graph.  
Contains private field `id`, constructor, getter, `toString()`, `equals()` and `hashCode()` methods.

### Edge Class
Represents a connection between two vertices.  
Contains `source` and `destination` vertices, constructor and getters.

### Graph Class
Main class that manages the graph using Adjacency List (`Map<Vertex, List<Vertex>>`).  
Key methods: `addVertex()`, `addEdge()`, `printGraph()`, `bfs()`, `dfs()`.

### Experiment Class
Responsible for running traversals and performance tests.  
Contains `runTraversals()`, `runMultipleTests()` and result handling.

### Main Class
Entry point of the application. Creates sample graphs and launches experiments.

## Algorithm Descriptions

### Breadth-First Search (BFS)
BFS explores all vertices at the current depth level before moving to the next level. It uses a **Queue**.

**Step-by-step:**
1. Start at the source vertex and mark it as visited.
2. Enqueue the source vertex.
3. While the queue is not empty, dequeue a vertex and enqueue all its unvisited neighbors.

**Use cases:** Shortest path in unweighted graphs, web crawling, finding connected components.  
**Time Complexity:** O(V + E)

### Depth-First Search (DFS)
DFS explores as far as possible along each branch before backtracking. It uses **recursion** (implicit stack).

**Step-by-step:**
1. Start at the source vertex and mark it as visited.
2. Recursively visit all unvisited adjacent vertices.

**Use cases:** Path finding, topological sorting, maze solving, cycle detection.  
**Time Complexity:** O(V + E)

## Experimental Results

### Execution Time Comparison

| Graph Size       | BFS Time (ms)     | DFS Time (ms)     | Faster Algorithm |
|------------------|-------------------|-------------------|------------------|
| 10 vertices      | 1.0 – 2.0         | 0.7 – 1.5         | DFS              |
| 30 vertices      | 2.5 – 4.0         | 1.0 – 2.0         | DFS              |
| 100 vertices     | 5.0 – 8.0         | 2.0 – 4.0         | DFS              |

**Observations:**
- Both algorithms have linear time complexity, matching the expected O(V + E).
- DFS was consistently faster than BFS in my tests, mainly due to lower overhead compared to queue operations.
- Time increases proportionally with graph size.

## Screenshots

- Graph structure output (Adjacency List)
- BFS and DFS traversal on small graph (10 vertices)
- Performance test results
- <img width="706" height="737" alt="Снимок экрана 2026-05-10 160137" src="https://github.com/user-attachments/assets/84a02f1d-e5d0-4497-b245-03588d02e971" />


*(Screenshots will be added in the `docs/screenshots/` folder)*

## Reflection

During this assignment I gained a much better understanding of graph structures and traversal algorithms. Implementing both BFS and DFS helped me clearly see the differences between level-order and depth-order exploration.

BFS is preferable when we need the shortest path in an unweighted graph or when exploring level by level. DFS is more memory efficient in some cases and faster at reaching deep nodes, but it doesn't guarantee the shortest path.

**Challenges faced:**
- Properly handling Vertex objects in collections (needed equals and hashCode)
- Controlling output during performance measurements
- Organizing the project structure according to requirements

