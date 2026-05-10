public class Main {

    public static void main(String[] args) {
        Experiment experiment = new Experiment();

        System.out.println("=== Small Graph (10 vertices) ===");
        Graph smallGraph = createSmallGraph();
        smallGraph.printGraph();

        experiment.runTraversals(smallGraph);

        experiment.runMultipleTests();
    }

    private static Graph createSmallGraph() {
        Graph g = new Graph();
        for (int i = 0; i < 10; i++) {
            g.addVertex(new Vertex(i));
        }
        for (int i = 0; i < 10; i++) {
            g.addEdge(i, (i + 1) % 10);
            g.addEdge(i, (i + 2) % 10);
            g.addEdge(i, (i + 3) % 10);
        }
        return g;
    }
}