package models;

import java.util.HashSet;
import java.util.Set;


public class WeightedGraph <V>{

    private Set<Vertex<V>> vertices;
    boolean directed;


    public WeightedGraph() {
        this(false);
    }


    public WeightedGraph(boolean directed) {
        this.directed = directed;
        vertices = new HashSet<>();
    }


    public Set<Vertex<V>> getVertices() {
        return vertices;
    }


    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }


    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight ) {
        vertices.add(source);
        vertices.add(destination );

        Vertex<V> sourceVertex = vertices.stream().filter(v -> v.equals(source)).findFirst().get();
        Vertex<V> destinationVertex = vertices.stream().filter(v -> v.equals(destination )).findFirst().get();

        sourceVertex.addAdjacentVertex(destinationVertex, weight);
        if(!directed){
            destinationVertex.addAdjacentVertex(sourceVertex, weight);
        }
    }


    public Vertex<V> getVertexByValue(V value) {
        for (Vertex<V> vertex : vertices) {
            if (vertex.toString().contains(String.valueOf(value))) {
                return vertex;
            }
        }
        return null;
    }
}
