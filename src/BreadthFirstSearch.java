import java.util.*;

public class BreadthFirstSearch<V> implements Search<V>{
    private final WeightedGraph<V> graph;
    private Map<V, Boolean> visited;
    private Map<V, V> edgeTo;
    private final V source;

    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        this.source = source;
        this.graph = graph;
        visited = new HashMap<>();
        edgeTo = new HashMap<>();

        bfs(source);
    }

    private void bfs(V source) {
        Queue<V> queue = new LinkedList<>();
        visited.put(source,true);
        queue.add(source);

        while(!queue.isEmpty()){
            V current = queue.remove();
            Vertex<V> currentVertex = graph.getVertex(current);
            if(currentVertex==null) continue;

            HashMap<Vertex<V>, Double> connections = currentVertex.getConnections();
            for(Map.Entry<Vertex<V>,Double> entry : connections.entrySet()){
                V neighbor = entry.getKey().getInfo();
                if(!visited.containsKey(neighbor)|| !visited.get(neighbor)){
                    visited.put(neighbor,true);
                    edgeTo.put(neighbor,current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(V vertex) {
        return visited.containsKey(vertex) && visited.get(vertex);
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