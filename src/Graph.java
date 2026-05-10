import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjacencyList;
    private List<Vertex> vertices;

    public Graph() {
        adjacencyList = new HashMap<>();
        vertices = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
            vertices.add(v);
        }
    }

    public void addEdge(int from, int to) {
        Vertex vFrom = findVertex(from);
        Vertex vTo = findVertex(to);

        if (vFrom != null && vTo != null) {
            adjacencyList.get(vFrom).add(vTo);
        }
    }

    private Vertex findVertex(int id) {
        for (Vertex v : vertices) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public void printGraph() {
        System.out.println("Graph adjacency list:");
        for (Vertex v : vertices) {
            System.out.print(v.getId() + " -> ");
            for (Vertex neighbor : adjacencyList.get(v)) {
                System.out.print(neighbor.getId() + " ");
            }
            System.out.println();
        }
    }


    public void bfs(int start) {
        bfs(start, true);
    }

    public void bfs(int start, boolean printOrder) {
        Vertex startVertex = findVertex(start);
        if (startVertex == null) return;

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        if (printOrder) {
            System.out.print("BFS starting from " + start + ": ");
        }

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (printOrder) {
                System.out.print(current.getId() + " ");
            }

            for (Vertex neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        if (printOrder) System.out.println();
    }

    public void dfs(int start) {
        dfs(start, true);
    }

    public void dfs(int start, boolean printOrder) {
        Vertex startVertex = findVertex(start);
        if (startVertex == null) return;

        Set<Vertex> visited = new HashSet<>();
        if (printOrder) {
            System.out.print("DFS starting from " + start + ": ");
        }
        dfsUtil(startVertex, visited, printOrder);
        if (printOrder) System.out.println();
    }

    private void dfsUtil(Vertex vertex, Set<Vertex> visited, boolean printOrder) {
        visited.add(vertex);
        if (printOrder) {
            System.out.print(vertex.getId() + " ");
        }

        for (Vertex neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited, printOrder);
            }
        }
    }
}