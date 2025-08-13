
import java.util.*;

public class Topological_sorting {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src = src;
            this.wt = wt;
            this.dest = dest;
        }
    }



    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        // 0th vertex
        graph[0].add(new Edge(0, 1, 1));

        // 1st vertex
        graph[1].add(new Edge(1, 2, 1));

        // 2nd vertex
        graph[2].add(new Edge(2, 3, 1));

        // 3rd vertex
        graph[3].add(new Edge(3, 1, 1)); // This creates a cycle: 1 → 2 → 3 → 1

        // 4th vertex
        // No outgoing edges for illustration, but you could add more

    }

   public static void TopSort(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();

    for (int i = 0; i < graph.length; i++) {
        if(!vis[i]){
            topsortutil(graph,i,vis,s);
        }
    }
    while(!s.isEmpty()){
        System.out.print(s.pop()+"  ");
    }
}
    public static void topsortutil(ArrayList<Edge>[] graph, int curr, boolean[] vis,Stack<Integer> s) {
    // Mark the current node as visited
    vis[curr] = true;


    // Traverse all edges from the current node
    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if (!vis[e.dest]) {
                topsortutil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }


    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];//->null arraylist
        creategraph(graph);
        TopSort(graph);

    }

}
