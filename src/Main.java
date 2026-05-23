public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();


        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);


        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);


        System.out.println("бонусное задание:Спасибо большое за банус АПАЙ");
        graph.dijkstra(0);
    }
}