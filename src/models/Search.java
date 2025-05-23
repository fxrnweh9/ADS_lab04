package models;

import java.util.*;


public abstract class Search<V> {

    private final Vertex<V> source;
    Set<Vertex<V>> visited;
    Map<Vertex<V>, Vertex<V>> path;


    protected Search(Vertex<V> source) {
        this.source = source;
        this.visited = new HashSet();
        this.path = new HashMap();
    }


    public boolean hasPathTo(Vertex<V> v) {
        return visited.contains(v);
    }


    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) {
            return null;
        }

        LinkedList<Vertex<V>> list = new LinkedList<>();

        while (v != source) {
            list.push(v);
            v = path.get(v);
        }
        list.push(source);

        return list;
    }
}