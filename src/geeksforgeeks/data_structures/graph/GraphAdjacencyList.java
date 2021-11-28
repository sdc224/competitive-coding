package geeksforgeeks.data_structures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphAdjacencyList {
    List<List<Integer>> graph;
    int vertex;
    int edge;
    boolean visited[];

    private void init() {
        for (int i = 0; i < vertex; i++)
            graph.add(new ArrayList<>());
    }

    public GraphAdjacencyList(int v, int e) {
        vertex = v;
        edge = e;
        graph = new ArrayList<>(vertex);
        visited = new boolean[vertex];
        this.init();
        this.input();
    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private void input() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < edge; i++) {
            String input = sc.nextLine();

            int l = input.indexOf(' ');
            if (l >= 0) {
                String start = input.substring(0, l);
                String end = input.substring(l + 1);

                int u = Integer.parseInt(start);
                int v = Integer.parseInt(end);
                this.addEdge(u, v);
            }

        }

        sc.close();
    }

    public void dfs(int curr) {
        visited[curr] = true;

        for (int i : graph.get(curr)) {
            if (visited[i])
                continue;
            dfs(i);
        }
    }

    public int getConnectedComponents() {
        int ans = 0;
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }

        return ans;
    }

    public void print() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("\nAdjacency list of vertex " + i);
            System.out.print("head");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" -> " + graph.get(i).get(j));
            }
            System.out.println();
        }
    }
}
