# ADS Project - Graph Algorithms & Bonus Task
#Ibraimov Abbaskhan IT-2501
This repository contains the implementation of a Graph data structure in Java, including standard traversal algorithms (BFS, DFS) and the completion of the Bonus Task (Dijkstra's Algorithm).

## Bonus Task Implementation (+5 points)
According to the assignment requirements, the following updates were made to the existing project to support Dijkstra's Algorithm for finding the shortest path:

### 1. Edge Weights
- The `Edge` class was completely refactored to include a `weight` field. 
- It now stores the `target` Vertex and the `weight` of the connection.

### 2. Graph Structure Update
- The main graph structure in the `Graph` class was updated from an unweighted adjacency list (`Map<Vertex, List<Vertex>>`) to a weighted adjacency list (`Map<Vertex, List<Edge>>`).
- Existing traversal algorithms (BFS and DFS) were modified to remain compatible with the new `Edge` structure.

### 3. Dijkstra's Algorithm (`void dijkstra(int start)`)
- The algorithm calculates the shortest path from a starting vertex to all other reachable vertices.
- **Implementation notes:** It strictly uses simple loops, arrays/maps for keeping track of distances, and a visited set. Priority Queues were deliberately avoided as per the assignment's suggestion.
- The method prints out clear results, showing the minimum distance from the starting vertex to every other vertex in the graph, or "Unreachable/INF" if no path exists.

### How to test:
1. Create a `Graph` instance.
2. Add vertices using `addVertex(new Vertex(id))`.
3. Add weighted edges using `addEdge(sourceId, targetId, weight)`.
4. Call `graph.dijkstra(startId)` to see the console output.

<img width="1919" height="1026" alt="Снимок экрана 2026-05-23 093912" src="https://github.com/user-attachments/assets/9ab8cf0a-b4ba-4818-be58-ea9a2a18e530" />
