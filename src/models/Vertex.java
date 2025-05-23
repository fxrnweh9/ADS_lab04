package models;

import java.util.HashMap;
import java.util.Map;


public class Vertex<V> {

    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;


    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }


    public V getData() {
        return data;
    }


    public void addAdjacentVertex(Vertex<V> v, double weight) {
        adjacentVertices.put(v, weight);
    }


    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }


    @Override
    public int hashCode() {
        return data.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Vertex)) {
            return false;
        }

        Vertex<V> other = (Vertex<V>) obj;
        return data.equals(other.data);
    }


    @Override
    public String toString() {
        return "Vertex{" + "data = " + data + '}';
    }
}