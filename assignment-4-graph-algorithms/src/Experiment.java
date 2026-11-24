public class Experiment {
    private long[] bfsTimes;
    private long[] dfsTimes;
    private int[] graphSizes;

    public Experiment() {
        graphSizes = new int[]{10, 30, 100};
        bfsTimes = new long[graphSizes.length];
        dfsTimes = new long[graphSizes.length];
    }

    public void runTraversals(Graph g) {
        g.bfs(0);
        g.dfs(0);
    }

    public void runMultipleTests() {
        System.out.println("=== Performance Testing ===\n");

        for (int i = 0; i < graphSizes.length; i++) {
            int n = graphSizes[i];
            Graph g = buildGraph(n);

            long startBfs = System.nanoTime();
            g.bfs(0);
            long endBfs = System.nanoTime();
            bfsTimes[i] = endBfs - startBfs;

            long startDfs = System.nanoTime();
            g.dfs(0);
            long endDfs = System.nanoTime();
            dfsTimes[i] = endDfs - startDfs;

            System.out.println("Graph size: " + n + " vertices");
            System.out.println("  BFS time: " + bfsTimes[i] + " ns");
            System.out.println("  DFS time: " + dfsTimes[i] + " ns\n");
        }
    }

    public void printResults() {
        System.out.println("=== Results Table ===");
        System.out.println("Vertices | BFS (ns)   | DFS (ns)");
        System.out.println("---------+------------+------------");
        for (int i = 0; i < graphSizes.length; i++) {
            System.out.printf("%-9d| %-11d| %-11d%n",
                    graphSizes[i], bfsTimes[i], dfsTimes[i]);
        }
    }

    private Graph buildGraph(int n) {
        Graph g = new Graph(n);
        for (int i = 0; i < n - 1; i++) {
            g.addEdge(i, i + 1);
            if (i + 2 < n) g.addEdge(i, i + 2);
        }
        return g;
    }
}
