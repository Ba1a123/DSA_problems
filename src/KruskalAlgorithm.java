import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}

class KruskalAlgorithm {
    int vertices;
    ArrayList<Edge> edges;
    int[] parent;

    KruskalAlgorithm(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
        parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }
    }

    void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge();
        edge.source = source;
        edge.destination = destination;
        edge.weight = weight;
        edges.add(edge);
    }

    int findParent(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = findParent(parent[vertex]);
        }
        return parent[vertex];
    }

    void union(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);
        parent[xParent] = yParent;
    }

    void kruskalMST() {
        ArrayList<Edge> minimumSpanningTree = new ArrayList<>();
        Collections.sort(edges);

        int edgeCount = 0;
        int index = 0;
        while (edgeCount < vertices - 1) {
            Edge nextEdge = edges.get(index++);
            int x = findParent(nextEdge.source);
            int y = findParent(nextEdge.destination);

            if (x != y) {
                minimumSpanningTree.add(nextEdge);
                union(x, y);
                edgeCount++;
            }
        }

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.source + " -- " + edge.destination + " => " + edge.weight);
        }

        System.out.println("Parent vertices:");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " : " + parent[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        KruskalAlgorithm graph = new KruskalAlgorithm(vertices);

        // Adding edges
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(0, 2, 7);
        graph.addEdge(2, 4, 5);

        graph.kruskalMST();
    }
}
