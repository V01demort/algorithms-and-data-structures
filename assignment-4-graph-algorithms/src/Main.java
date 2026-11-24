public class Main {
    public static void main(String[] args) {

        System.out.println("=== Small Graph (10 vertices) ===");
        Graph small = new Graph(10);
        small.addEdge(0, 1); small.addEdge(0, 2);
        small.addEdge(1, 3); small.addEdge(1, 4);
        small.addEdge(2, 5); small.addEdge(2, 6);
        small.addEdge(3, 7); small.addEdge(4, 8);
        small.addEdge(5, 9);
        small.printGraph();
        System.out.println();

        Experiment exp = new Experiment();
        exp.runTraversals(small);
        System.out.println();

        System.out.println("=== Medium Graph (30 vertices) ===");
        Graph medium = new Graph(30);
        for (int i = 0; i < 29; i++) {
            medium.addEdge(i, i + 1);
            if (i + 2 < 30) medium.addEdge(i, i + 2);
        }
        System.out.println("Graph created: 30 vertices, directed edges.\n");

        System.out.println("=== Large Graph (100 vertices) ===");
        Graph large = new Graph(100);
        for (int i = 0; i < 99; i++) {
            large.addEdge(i, i + 1);
            if (i + 2 < 100) large.addEdge(i, i + 2);
        }
        System.out.println("Graph created: 100 vertices, directed edges.\n");

        System.out.println("=== Performance Experiments ===\n");
        exp.runMultipleTests();
        System.out.println();
        exp.printResults();

        System.out.println("\n=== BONUS: Dijkstra's Algorithm ===");
        Graph weighted = new Graph(6);
        weighted.addEdge(0, 1, 4);
        weighted.addEdge(0, 2, 5);
        weighted.addEdge(1, 3, 2);
        weighted.addEdge(1, 4, 1);
        weighted.addEdge(2, 4, 3);
        weighted.addEdge(3, 5, 6);
        weighted.addEdge(4, 5, 1);

        weighted.printGraph();
        System.out.println();
        weighted.dijkstra(0);
    }
}
