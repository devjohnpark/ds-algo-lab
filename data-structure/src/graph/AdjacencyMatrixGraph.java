package graph;

import java.util.*;

// Support directed/undirected graph
public final class AdjacencyMatrixGraph {
    private final int n;              // number of vertices (1..n)
    private final boolean directed;   // undirected = false
    private final int[][] a;          // 0/1 matrix

    public AdjacencyMatrixGraph(int n, boolean directed) {
        if (n <= 0) throw new IllegalArgumentException("n must be > 0");
        this.n = n;
        this.directed = directed;
        this.a = new int[n][n];
    }

    // Add an edge between u and v (1-based vertex indices)
    public void addEdge(int u, int v) {
        check(u); check(v);
        a[u-1][v-1] = 1;
        if (!directed) a[v-1][u-1] = 1;
    }

    // Remove an edge between u and v (1-based)
    public void removeEdge(int u, int v) {
        check(u); check(v);
        a[u-1][v-1] = 0;
        if (!directed) a[v-1][u-1] = 0;
    }

    // Is there an edge u->v ? (1-based)
    public boolean hasEdge(int u, int v) {
        check(u); check(v);
        return a[u-1][v-1] == 1;
    }

    // Neighbors of u (1-based)
    public List<Integer> neighbors(int u) {
        check(u);
        List<Integer> res = new ArrayList<>();
        for (int v = 1; v <= n; v++) if (a[u-1][v-1] == 1) res.add(v);
        return res;
    }

    // For printing exactly like the chalkboard matrix
    public void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
                if (j + 1 < n) System.out.print(' ');
            }
            System.out.println();
        }
    }

    public int[][] toArray() { return a; }

    private void check(int u) {
        if (u < 1 || u > n) throw new IndexOutOfBoundsException("vertex out of range: " + u);
    }

    // Demo: build the exact graph from the image and print the matrix
    public static void main(String[] args) {
//        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(4, /*directed=*/false);
        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(4, /*directed=*/true);

        // edges: (1,2), (1,3), (1,4), (3,4)
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 4);

        g.printMatrix();
        // directed:
        // 0 1 1 1
        // 0 0 0 0
        // 0 0 0 1
        // 0 0 0 0

        // undirected:
        // 0 1 1 1
        // 1 0 0 0
        // 1 0 0 1
        // 1 0 1 0

        System.out.println("Neighbors of 1: " + g.neighbors(1)); // directed: [2, 3, 4], undirected: [2, 3, 4]
        System.out.println("Neighbors of 1: " + g.neighbors(2)); // directed: [], undirected: [1]
        System.out.println("hasEdge(3,4) = " + g.hasEdge(4,3)); // directed: false, undirected: true
    }
}
