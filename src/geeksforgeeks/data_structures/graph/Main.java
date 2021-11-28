package geeksforgeeks.data_structures.graph;

public class Main {
    public static void main(String[] args) {
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(6, 4);
        System.out.println(graph.getConnectedComponents());
    }
}
