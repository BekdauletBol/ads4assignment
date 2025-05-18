import java.util.HashMap;
import java.util.Objects;

public class Vertex<V> {
    private V info;
    private HashMap<Vertex<V>, Double> connections;

    public Vertex(V info) {
        this.info = info;
        this.connections = new HashMap<>();
    }

    public void putConnection(Vertex<V> destination, double weight) {
        connections.put(destination, weight);
    }

    public V getInfo() {
        return info;
    }

    public void setInfo(V data) {
        this.info = info;
    }

    public HashMap<Vertex<V>, Double> getConnections() {
        return connections;
    }

    public void setConnections(HashMap<Vertex<V>, Double> connections) {
        this.connections = connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(info, ((Vertex<?>) o).info);
    }
}