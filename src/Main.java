import models.*;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        fillGraph(graph);

        Vertex<String> source = graph.getVertexByValue("Almaty");
        Vertex<String> target = graph.getVertexByValue("Kokshetau");

        System.out.println("Dijkstra search");
        Search<String> djk = new Dijkstra<>(graph, source);
        outputPath(djk, target);

        System.out.println("//////////////////////////////////////////////////////////");

        System.out.println("Breadth first search");
        Search<String> bfs = new BFS<>(graph, source);
        outputPath(bfs, target);
    }


    public static void fillGraph(WeightedGraph<String> graph) {
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Astana"), 9.9);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Atyrau"), 9.0);
        graph.addEdge(new Vertex<>("Atyrau"), new Vertex<>("Astana"), 8.2);
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Shymkent"), 5.6);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Astana"), 7.4);
        graph.addEdge(new Vertex<>("Astana"), new Vertex<>("Kostanay"), 2.9);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Kokshetau"), 9.3);
    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        for (Vertex<String> v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}