package models;

public class Edge<Vertex> {

    private Vertex source;
    private Vertex dest;
    private Double weight;

    public Edge(Vertex source, Vertex dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public <T> Edge(models.Vertex<T> source, models.Vertex<T> destination) {
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDest() {
        return dest;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
