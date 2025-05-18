import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<V, Double> distTo;
    private Map<V, V> edgeTo;
    private final V source;
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        this.graph = graph;
        this.source = source;
        distTo = new HashMap<>();
        edgeTo = new HashMap<>();

        dijkstra(source);
    }

    private void dijkstra(V source) {
        Set<V> unvisited = new HashSet<>();
        Vertex<V> sourceVertex = graph.getVertex(source);
        if(sourceVertex==null) return;
        distTo.put(source,0.0);
        unvisited.add(source);

        while (!unvisited.isEmpty()){
            V current = getMinDistanceVertex(unvisited);
            unvisited.remove(current);
            if(current == null) break;

            Vertex<V> currentvertex = graph.getVertex(current);
            HashMap<Vertex<V>,Double> connections = currentvertex.getConnections();
            for(Map.Entry<Vertex<V>,Double> entry : connections.entrySet()){
                Vertex<V> adjVertex = entry.getKey();
                V adjVertexInfo = adjVertex.getInfo();
                Double weight = entry.getValue();

                double newDist = distTo.getOrDefault(current, Double.POSITIVE_INFINITY) + weight;
                if(!distTo.containsKey(adjVertexInfo)|| newDist < distTo.get(adjVertexInfo)){
                    distTo.put(adjVertexInfo,newDist);
                    edgeTo.put(adjVertexInfo,current);
                    unvisited.add(adjVertexInfo);
                }
            }
        }
    }

    private V getMinDistanceVertex(Set<V> unvisited) {
        V minVertex = null;
        double minDistance = Double.POSITIVE_INFINITY;

        for (V vertex : unvisited) {
            double dist = distTo.getOrDefault(vertex, Double.POSITIVE_INFINITY);
            if (dist < minDistance) {
                minDistance = dist;
                minVertex = vertex;
            }
        }
        return minVertex;
    }

    @Override
    public boolean hasPathTo(V vertex) {
        return distTo.containsKey(vertex);
    }

    @Override
    public List<V> pathTo(V vertex) {
        if (!hasPathTo(vertex)) {
            return new ArrayList<>();
        }
        List<V> path = new ArrayList<>();
        V current = vertex;
        while (!current.equals(source)) {
            path.add(current);
            current = edgeTo.get(current);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }
}