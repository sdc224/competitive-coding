package geeksforgeeks.data_structures.graph;

import java.util.Scanner;

public class GraphAdjacencyMatrix {
    boolean[][] matrix;
    int vertex;
    int edges;
    boolean visited[][];

    private void init(int v, int e) {
        matrix = new boolean[v][v];
        visited = new boolean[v][v];
        vertex = v;
        edges = e;
    }

    private void input() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                if (i != j && !matrix[i][j]) {
                    System.out.print("Enter true if there is a path between " + i + " & " + j + ": ");
                    boolean c = sc.nextBoolean();
                    matrix[i][j] = c;
                    matrix[j][i] = c;
                }
            }
        }

        sc.close();
    }

    public GraphAdjacencyMatrix(int v, int e) {
        this.init(v, e);
        this.input();
    }

    private boolean isSafe(int row, int col) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < vertex) && (col >= 0) && (col < vertex)
                && (matrix[row][col] && !visited[row][col]);
    }

    public void dfs(int row, int col) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(row + rowNbr[k], col + colNbr[k]))
                dfs(row + rowNbr[k], col + colNbr[k]);
    }

    public int getConnectedComponents() {
        int ans = 0;

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                if (matrix[i][j] && !visited[i][j]) {
                    this.dfs(i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    public void print() {
        for (int i = 0; i < vertex; i++)
            for (int j = 0; j < vertex; j++)
                System.out.println(matrix[i][j]);

    }
}
