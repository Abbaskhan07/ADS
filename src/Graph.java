import java.util.*;

public class Graph {

    private Map<Vertex, List<Edge>> adjacencyList;
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


    public void addEdge(int from, int to, int weight) {
        Vertex vFrom = findVertex(from);
        Vertex vTo = findVertex(to);

        if (vFrom != null && vTo != null) {
            adjacencyList.get(vFrom).add(new Edge(vTo, weight));
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
            for (Edge edge : adjacencyList.get(v)) {
                System.out.print(edge.getTarget().getId() + "(w:" + edge.getWeight() + ") ");
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


            for (Edge edge : adjacencyList.get(current)) {
                Vertex neighbor = edge.getTarget();
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


        for (Edge edge : adjacencyList.get(vertex)) {
            Vertex neighbor = edge.getTarget();
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited, printOrder);
            }
        }
    }


    public void dijkstra(int start) {
        Vertex startVertex = findVertex(start);
        if (startVertex == null) {
            System.out.println("Vertex not found.");
            return;
        }

        Map<Vertex, Integer> distances = new HashMap<>();
        Set<Vertex> visited = new HashSet<>();


        for (Vertex v : vertices) {
            distances.put(v, Integer.MAX_VALUE);
        }
        distances.put(startVertex, 0);

        for (int i = 0; i < vertices.size(); i++) {

            Vertex current = null;
            int minDistance = Integer.MAX_VALUE;

            for (Vertex v : vertices) {
                if (!visited.contains(v) && distances.get(v) < minDistance) {
                    minDistance = distances.get(v);
                    current = v;
                }
            }


            if (current == null) break;
            visited.add(current);

            for (Edge edge : adjacencyList.get(current)) {
                Vertex neighbor = edge.getTarget();
                if (!visited.contains(neighbor)) {
                    int newDist = distances.get(current) + edge.getWeight();
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                    }
                }
            }
        }

        System.out.println("Shortest distances from vertex " + start + ":");
        for (Vertex v : vertices) {
            int dist = distances.get(v);
            System.out.println("To vertex " + v.getId() + " : " + (dist == Integer.MAX_VALUE ? "Unreachable/INF" : dist));
        }
    }
}