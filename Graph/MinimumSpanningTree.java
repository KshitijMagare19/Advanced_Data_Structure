package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class MinimumSpanningTree {
    private int numVertices;
    private List<List<Edge>> adjacencyList;

    public MinimumSpanningTree(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; ++i) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);
        adjacencyList.get(destination).add(edge);
    }

    public List<Edge> primMST() {
        boolean[] visited = new boolean[numVertices];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        List<Edge> mstEdges = new ArrayList<>();

        // Start with the first vertex
        minHeap.add(new Edge(0, 0, 0));

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int u = edge.destination;

            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            mstEdges.add(edge);

            for (Edge adjacentEdge : adjacencyList.get(u)) {
                if (!visited[adjacentEdge.destination]) {
                    minHeap.add(adjacentEdge);
                }
            }
        }

        return mstEdges;
    }

    public static void main(String[] args) {
        int numVertices = 5; // Number of offices
        MinimumSpanningTree graph = new MinimumSpanningTree(numVertices);

        // Adding edges (office1, office2, cost)
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 5);

        List<Edge> mstEdges = graph.primMST();

        // Print the Minimum Spanning Tree edges and their total cost
        int totalCost = 0;
        System.out.println("\nMinimum Spanning Tree edges and their total cost:\n");
        for (Edge edge : mstEdges) {
            System.out.println("Office " + edge.source + " - Office " + edge.destination + ": Cost - " + edge.weight);
            totalCost += edge.weight;
        }
        System.out.println("\nTotal Cost: " + totalCost);
    }
}

