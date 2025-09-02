package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Adjacency List: 연결리스트로 그래프를 표현 (DirectedGraph와 UndirectedGraphWithDfsBfs 중에서 UndirectedGraphWithDfsBfs 표현)
public class UndirectedGraphWithDfsBfs {
    // 각 Node에 인접한 노드들이 연결된 연결리스트가 저장하도록하여, 특정 노드로 이동시 인접한 모든 노드를 팀색할수있다.
    class Node {
        private final int data; // 노드의 데이터
        private final LinkedList<Node> adjacent; // 인접한 노드들을 알기 위한 연결리스트
        private boolean marked; // 순회한 노드인지 확인하기 위한 변수
        public Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    private final Node[] nodes; // 그래프는 여러 노드를 가짐

    public UndirectedGraphWithDfsBfs(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    // i1 인덱스의 노드와 i2 인덱스의 노드를 연결
    public void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        // 인덱스로 접근한 연결리스트의 인접한 노드들중에서 해당 노드가 없으면 추가
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    // default: dfs 순회시 0번부터 시작
    public void dfs() {
        dfs(0);
    }

    // dfs 순회 결과를 출력하는 메서드 (매개변쉬: 시작 인덱스 설정)
    public void dfs(int index) {
        Node root = nodes[index]; // 순회를 시작할 노드 가져오기
        Stack<Node> stack = new Stack<>(); // dfs 순회를 위한 스택
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            // 1. 먼저 부모 노드 pop
            root = stack.pop();

            // 2. 인접한 노드중에서 스택에 추가되지 않았던 노드만 추가한다.
            for (Node node: root.adjacent) { // 해당 노드와 인접한 노드를 자식 노드 끝까지 순차대로 탐색하기 위해서 스택을 사용한다. 그래야 끝까지 상위 노드로 올라가가 때문이다.
                // 각 Node에 인접한 노드들이 연결된 연결리스트가 저장하도록하여, 특정 노드로 이동시 인접한 모든 노드를 팀색할수있다.
                // 따라서 한번 스택에 추가한 노드를 제외시켜야한다.
                if (!node.marked) {
                    node.marked = true;
                    stack.push(node);
                }
            }

            // 3. 루트 노드의 데이터 출력
            visit(root);
        }
    }

    public void bfs() {
        bfs(0);
    }

    public void bfs(int index) {
        Node root = nodes[index]; // 순회를 시작할 노드 가져오기
        Queue<Node> queue = new LinkedList<>(); // bfs 순회를 위한 큐
        queue.add(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            // 1. 먼저 부모 노드 삭제
            root = queue.remove();

            // 2. 인접한 노드중에서 큐에 추가되지 않았던 노드만 추가한다.
            for (Node node : root.adjacent) {
                if (!node.marked) {
                    node.marked = true;
                    queue.add(node);
                }
            }

            // 3. 루트 노드의 데이터 출력
            visit(root);
        }
    }

    public void dfsRecursive() {
        dfsRecursive(0);
    }

    public void dfsRecursive(int index) {
        Node root = nodes[index];
        dfsRecursive(root);
    }

    private void dfsRecursive(Node r) {
        if (r == null) return;
        // 1. 노드 호출한것 저장
        r.marked = true;

        // 2. 루트 노드의 데이터 출력
        visit(r);

        // 3. 아직 호출이 되지 않은 인접 노드를 출력
        for (Node node : r.adjacent) {
            if (!node.marked) {
                dfsRecursive(node);
            }
        }
    }

    private void visit(Node node) {
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        /*
        -----------------------------
            0
           /
          1 -- 3     7
          |  / | \  /
          | /  |  5
          2 -- 4    \
                      6 -- 8

        DFS(0)
        0 1 3 5 7 6 8 4 2

        BFS(0)
        0 1 2 3 4 5 6 7 8

        DFS(0) - Recursive
        0 1 2 4 3 5 6 8 7

        --------------------
        DFS(3)
        3 5 7 6 8 4 2 1 0

        BFS(3)
        3 1 2 4 5 0 6 7 8

        DFS(3) - Recursive
        3 1 0 2 4 5 6 8 7
        */

        UndirectedGraphWithDfsBfs g = new UndirectedGraphWithDfsBfs(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        g.dfs();
//        g.bfs();
//        g.dfsRecursive();
//        g.dfs(3);
//        g.bfs(3);
//        g.dfsRecursive(3);
    }
}