public class Experiment {

    public void runTraversals(Graph g) {
        System.out.println("\n=== Running Traversals on Small Graph ===");
        g.bfs(0);
        g.dfs(0);
    }

    public void runMultipleTests() {
        System.out.println("\n=== Performance Tests ===\n");

        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            Graph g = createGraph(size);

            // Измеряем BFS
            long start = System.nanoTime();
            g.bfs(0, false);           // без печати
            long end = System.nanoTime();
            long bfsTime = end - start;

            // Измеряем DFS
            start = System.nanoTime();
            g.dfs(0, false);           // без печати
            end = System.nanoTime();
            long dfsTime = end - start;

            System.out.printf("Graph with %d vertices → BFS: %.2f ms | DFS: %.2f ms%n",
                    size, bfsTime / 1_000_000.0, dfsTime / 1_000_000.0);
        }
    }

    private Graph createGraph(int numVertices) {
        Graph g = new Graph();

        // Добавляем вершины
        for (int i = 0; i < numVertices; i++) {
            g.addVertex(new Vertex(i));
        }

        // Добавляем ребра (смешанный граф)
        for (int i = 0; i < numVertices; i++) {
            for (int j = 1; j <= 3; j++) {
                int to = (i + j) % numVertices;
                g.addEdge(i, to);
            }
            // Добавляем несколько случайных ребер
            for (int k = 0; k < 2; k++) {
                int randomTo = (int) (Math.random() * numVertices);
                if (randomTo != i) {
                    g.addEdge(i, randomTo);
                }
            }
        }
        return g;
    }
}