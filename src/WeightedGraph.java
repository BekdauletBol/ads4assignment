import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private HashMap<V, Vertex<V>> graph = new HashMap<>();
    ;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public Vertex<V> getVertex(V info) {
        return graph.get(info);
    }

    public boolean hasVertex(V info) {
        return graph.containsKey(info);
    }

    public void addVertex(V info) {
        if (!hasVertex(info)) {
            graph.put(info, new Vertex<>(info));
        }
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source)) {
            addVertex(source);
        }
        if (!hasVertex(dest)) {
            addVertex(dest);
        }

        graph.get(source).putConnection(graph.get(dest), weight);

        if (!directed) {
            graph.get(dest).putConnection(graph.get(source), weight);
        }
    }
}