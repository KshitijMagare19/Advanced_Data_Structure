package Graph;

import java.util.ArrayList;

class graph {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //creating the edges of the graph
        // graph[0].add(new Edge(0,2));
        // graph[0].add(new Edge(0,4));

        // graph[1].add(new Edge(1,6));
        // graph[1].add(new Edge(1,8));

        // graph[2].add(new Edge(2,10));
        // graph[2].add(new Edge(2,12));

        // graph[3].add(new Edge(3,14));
        // graph[3].add(new Edge(3,16));

        // graph[4].add(new Edge(4,18));
        // graph[4].add(new Edge(4,20));

    }
    public static void insert(ArrayList<Edge>graph[],Edge e){
        graph[e.src].add(e);
        graph[e.dest].add(new Edge(e.dest, e.src));
    }
    public static void display(ArrayList<Edge>graph[]){
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + ": ");
            ArrayList<Edge> list = graph[i];
            for (Edge edge : list) {
                System.out.print(" { " + edge.src + " , " + edge.dest + " }");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int v = 7;                          // No. of vertex
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        insert(graph,new Edge(0,1));
        insert(graph,new Edge(0,2));
        insert(graph,new Edge(0,5));
        insert(graph,new Edge(1,2));
        insert(graph,new Edge(1,6));
        insert(graph,new Edge(2,5));
        insert(graph,new Edge(2,4));
        insert(graph,new Edge(2,3));
        insert(graph,new Edge(2,6));

        display(graph);

    }
}