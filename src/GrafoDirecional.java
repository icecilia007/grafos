import java.util.*;

public class GrafoDirecional {
    private Map<String, List<String>> graph = new HashMap<>();

    public GrafoDirecional() {
    }

    public GrafoDirecional(Map<String, List<String>> graph) {
        this.graph = graph;
    }

    public Map<String, List<String>> getGraph() {
        return graph;
    }

    public void setGraph(Map<String, List<String>> graph) {
        this.graph = graph;
    }
    public  void depth(Map<String, List<String>> graph, String source) {
        System.out.println(source);
        List<String> neighbors = graph.get(source);
        if (neighbors != null)
            for (String neighbor : neighbors) {
                depth(graph, neighbor);
            }
    }
    public  void breadth(Map<String, List<String>> graph, String source) {
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);
            List<String> neighbors = graph.get(current);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    queue.add(neighbor);
                }
            }
        }
    }
    public  boolean hasPath(Map<String, List<String>> graph, String src, String dst){
        if(Objects.equals(src, dst)) return true;
        for(String neighbor : graph.get(src)){
            if(hasPath(graph, neighbor, dst)){
                return true;
            }
        }
        return false;
    }
}
