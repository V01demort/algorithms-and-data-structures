public class Graph {
    private int[][] adj;
    private int[][] weight;
    private int[] deg;
    private int size;

    public Graph(int size) {
        this.size = size;
        adj    = new int[size][size];
        weight = new int[size][size];
        deg    = new int[size];
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void addEdge(int from, int to, int w) {
        if (w < 0) throw new IllegalArgumentException("Weight must be non-negative");
        if (deg[from] == size) throw new IllegalArgumentException("Edge capacity exceeded");
        adj[from][deg[from]]    = to;
        weight[from][deg[from]] = w;
        deg[from]++;
    }

    public void printGraph() {
        System.out.println("Graph adjacency list:");
        for (int i = 0; i < size; i++) {
            System.out.print("  " + i + " -> ");
            for (int j = 0; j < deg[i]; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(adj[i][j] + "(w=" + weight[i][j] + ")");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[size];
        int[] queue = new int[size];
        int head = 0, tail = 0;

        visited[start] = true;
        queue[tail++] = start;

        System.out.print("BFS: ");
        while (head < tail) {
            int current = queue[head++];
            System.out.print(current + " ");

            for (int i = 0; i < deg[current]; i++) {
                int neighbor = adj[current][i];
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue[tail++] = neighbor;
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[size];
        int[] stack = new int[size * size];
        int top = 0;

        stack[top++] = start;

        System.out.print("DFS: ");
        while (top > 0) {
            int current = stack[--top];
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");

                for (int i = deg[current] - 1; i >= 0; i--) {
                    if (!visited[adj[current][i]]) {
                        stack[top++] = adj[current][i];
                    }
                }
            }
        }
        System.out.println();
    }

    public void dijkstra(int start) {
        int[] dist    = new int[size];
        boolean[] visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        for (int count = 0; count < size; count++) {
            int u = -1;
            for (int i = 0; i < size; i++) {
                if (!visited[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }

            if (u == -1 || dist[u] == Integer.MAX_VALUE) break;

            visited[u] = true;

            for (int i = 0; i < deg[u]; i++) {
                int v = adj[u][i];
                int w = weight[u][i];
                if (w <= Integer.MAX_VALUE - dist[u] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        System.out.println("Dijkstra shortest paths from vertex " + start + ":");
        for (int i = 0; i < size; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("  -> " + i + ": unreachable");
            } else {
                System.out.println("  -> " + i + ": " + dist[i]);
            }
        }
    }

    public int getSize() {
        return size;
    }
}
