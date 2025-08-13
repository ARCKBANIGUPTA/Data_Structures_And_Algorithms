import java.util.*;
public class cycle_detection_directed {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void creategraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // 0th vertex
        graph[0].add(new Edge(0, 1));

        // 1st vertex
        graph[1].add(new Edge(1, 2));

        // 2nd vertex
        graph[2].add(new Edge(2, 3));

        // 3rd vertex
        graph[3].add(new Edge(3, 1)); // This creates a cycle: 1 → 2 → 3 → 1
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                if(isCycleUtil(graph, stack, vis, i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] stack, boolean[] vis, int curr){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest]){
                if(isCycleUtil(graph, stack, vis, e.dest)){
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        creategraph(graph);
        if(isCycle(graph)){
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }
    }
}
