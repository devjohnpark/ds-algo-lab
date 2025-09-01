package graph;

import java.util.*;

// Support directed/undirected graph (Adjacency List version)
public final class AdjacencyListGraph {
    private final int n;                     // vertices are 1..n
    private final boolean directed;          // undirected = false
    private final List<Set<Integer>> adj;    // adjacency list (no duplicates)

    public AdjacencyListGraph(int n, boolean directed) {
        if (n <= 0) throw new IllegalArgumentException("n must be > 0");
        this.n = n;
        this.directed = directed;
        this.adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new LinkedHashSet<>()); // keep insertion order
    }

    /** Add an edge between u and v (1-based vertex indices). */
    public void addEdge(int u, int v) {
        check(u); check(v);
        adj.get(u - 1).add(v);
        if (!directed && u != v) adj.get(v - 1).add(u);
    }

    /** Remove an edge between u and v (1-based). */
    public void removeEdge(int u, int v) {
        check(u); check(v);
        adj.get(u - 1).remove(v);
        if (!directed && u != v) adj.get(v - 1).remove(u);
    }

    /** Is there an edge u->v ? (1-based). */
    public boolean hasEdge(int u, int v) {
        check(u); check(v);
        return adj.get(u - 1).contains(v);
    }

    /** Neighbors of u (1-based). */
    public List<Integer> neighbors(int u) {
        check(u);
        List<Integer> res = new ArrayList<>(adj.get(u - 1));
        Collections.sort(res); // optional: sorted output
        return res;
    }

    /** Print as adjacency *list*. */
    public void printList() {
        for (int i = 1; i <= n; i++) {
            List<Integer> nbrs = neighbors(i);
            System.out.println(i + " : " + nbrs);
        }
    }

    /** (호환성용) 행렬 형태로 즉석 변환해 출력 */
    public void printMatrix() {
        int[][] a = toArray(); // build 0/1 matrix on the fly
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
                if (j + 1 < n) System.out.print(' ');
            }
            System.out.println();
        }
    }

    /** (호환성용) 현재 그래프를 0/1 인접 행렬로 변환해 반환 */
    public int[][] toArray() {
        int[][] a = new int[n][n];
        for (int u = 1; u <= n; u++) {
            for (int v : adj.get(u - 1)) a[u - 1][v - 1] = 1;
        }
        return a;
    }

    private void check(int u) {
        if (u < 1 || u > n)
            throw new IndexOutOfBoundsException("vertex out of range: " + u);
    }

    // Demo
    public static void main(String[] args) {
        // AdjacencyListGraph g = new AdjacencyListGraph(4, /*directed=*/false);
        AdjacencyListGraph g = new AdjacencyListGraph(4, /*directed=*/true);

        // edges: (1,2), (1,3), (1,4), (3,4)
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 4);

        System.out.println("== Adjacency List ==");
        g.printList();

        System.out.println("\n== As Matrix (for comparison) ==");
        g.printMatrix();

        System.out.println("Neighbors of 1: " + g.neighbors(1)); // directed: [2, 3, 4]
        System.out.println("Neighbors of 2: " + g.neighbors(2)); // directed: []
        System.out.println("hasEdge(4,3) = " + g.hasEdge(4, 3)); // directed: false
    }
}

