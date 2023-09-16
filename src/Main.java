import java.util.*;

public class Main {
    public static void main(String[] args) {
        GrafoDirecional graph1 = new GrafoDirecional();

        graph1.getGraph().put("a", Arrays.asList("b", "c"));
        graph1.getGraph().put("b", Arrays.asList("d"));
        graph1.getGraph().put("c", Arrays.asList("e"));
        graph1.getGraph().put("d", Arrays.asList("f"));
        graph1.getGraph().put("e", new ArrayList<>());
        graph1.getGraph().put("f", new ArrayList<>());

        graph1.depth(graph1.getGraph(), "a");
        System.out.println();
        graph1.breadth(graph1.getGraph(),"a");

        System.out.println();
        GrafoDirecional graph2 = new GrafoDirecional();
        graph2.getGraph().put("f", Arrays.asList("g", "i"));
        graph2.getGraph().put("g", Arrays.asList("h"));
        graph2.getGraph().put("h", Arrays.asList());
        graph2.getGraph().put("i", Arrays.asList("g", "k"));
        graph2.getGraph().put("j", Arrays.asList("i"));
        graph2.getGraph().put("k", Arrays.asList());

        graph2.depth(graph2.getGraph(), "f");
        System.out.println();
        graph2.breadth(graph2.getGraph(),"f");
        System.out.println("Tem caminho? "+ (graph2.hasPath(graph2.getGraph(), "f", "k") ? "SIM":"NÃO"));

        GrafoNaoDirecional graph = new GrafoNaoDirecional();
        graph.getGraph().put("1", Arrays.asList("2", "6"));
        graph.getGraph().put("2", Arrays.asList("1", "3", "6"));
        graph.getGraph().put("3", Arrays.asList("2", "4", "5"));
        graph.getGraph().put("4", Arrays.asList("3", "5", "7"));
        graph.getGraph().put("5", Arrays.asList("3", "4", "6"));
        graph.getGraph().put("6", Arrays.asList("1", "2"));
        graph.getGraph().put("7", List.of("4"));
        graph.getGraph().put("8", List.of());

        System.out.println("É conexo: "+ (graph.isGraphConnected(graph.getGraph()) ? "SIM":"NÃO"));

    }

}