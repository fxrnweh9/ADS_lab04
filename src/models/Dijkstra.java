package models;

import java.util.*;


public class Dijkstra<V> extends Search<V> {

    public Dijkstra(WeightedGraph<V> graph, Vertex<V> source) {
        super(graph.getVertices().stream().filter(v -> v.equals(source)).findFirst().get());
        dijkstra(graph, source);
    }


    private void dijkstra(WeightedGraph<V> graph, Vertex<V> source) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<Map.Entry<Vertex<V>, Double>> queue =
                new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));

        for (Vertex<V> v : graph.getVertices()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }


        distances.put(source, 0.0);
        queue.add(new AbstractMap.SimpleEntry<>(source, 0.0));


        while (!queue.isEmpty()) {
            Map.Entry<Vertex<V>, Double> current = queue.poll();
            Vertex<V> currentVertex = current.getKey();

            if (super.visited.contains(currentVertex)) continue;
            super.visited.add(currentVertex);

            for (Map.Entry<Vertex<V>, Double> neighbor : currentVertex.getAdjacentVertices().entrySet()) {
                double newDistance = distances.get(currentVertex) + neighbor.getValue();

                if (newDistance < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), newDistance);
                    super.path.put(neighbor.getKey(), currentVertex);
                    queue.add(new AbstractMap.SimpleEntry<>(neighbor.getKey(), newDistance));
                }
            }
        }
    }
}
