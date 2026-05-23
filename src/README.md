# ADS Project - Graph Algorithms & Bonus Task
#Ibraimov Abbaskhan IT-2501
This repository contains the implementation of a Graph data structure in Java, including standard traversal algorithms (BFS, DFS) and the completion of the Bonus Task (Dijkstra's Algorithm).

## Bonus Task Implementation 
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

<img width="883" height="699" alt="Снимок экрана 2026-05-23 095936" src="https://github.com/user-attachments/assets/d5b36056-130a-4139-9c77-b4ab38fea694" />
<img width="1124" height="753" alt="Снимок экрана 2026-05-23 095912" src="https://github.com/user-attachments/assets/d853f2e1-d20f-4f88-b9f6-f0a2808caa4d" />
<img width="1251" height="565" alt="Снимок экрана 2026-05-23 095857" src="https://github.com/user-attachments/assets/363ae1d0-0827-4572-b172-c15714943297" />

