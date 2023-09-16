import java.util.*;

public class GrafoNaoDirecional {
    private Map<String, List<String>> graph = new HashMap<>();

    public GrafoNaoDirecional() {
    }

    public GrafoNaoDirecional(Map<String, List<String>> graph) {
        this.graph = graph;
    }

    public Map<String, List<String>> getGraph() {
        return graph;
    }

    public void setGraph(Map<String, List<String>> graph) {
        this.graph = graph;
    }
    public boolean isGraphConnected(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        Set<String> nodes = graph.keySet();

        if (nodes.isEmpty()) {
            // Grafo vazio é considerado conexo
            return true;
        }
        // Inicie a busca a partir de um nó inicial (aqui, escolhemos o primeiro nó)
        String initialNode = nodes.iterator().next();
        depth(graph, initialNode, visited);
        // Verifique se todos os nós foram visitados
        return visited.size() == nodes.size();
    }
    public void depth(Map<String, List<String>> graph, String source, Set<String> visited) {
        System.out.println(source);
        //precisa verificar se foi visitado ou não para não causar loop
        visited.add(source);
        List<String> neighbors = graph.get(source);
        if (neighbors != null) {
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    depth(graph, neighbor, visited);
                }
            }
        }
    }
}
