import java.util.ArrayList;

public class cycleDetect_Undirected {
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
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 3));

        // 1st vertex
        graph[1].add(new Edge(1, 0, 2));
        graph[1].add(new Edge(1, 3, 1));

        // 2nd vertex
        graph[2].add(new Edge(2, 0, 3));
        graph[2].add(new Edge(2, 3, 4));
        graph[2].add(new Edge(2, 4, 5));

        // 3rd vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 2, 4));
        graph[3].add(new Edge(3, 4, 6));

        // 4th vertex
        graph[4].add(new Edge(4, 2, 5));
        graph[4].add(new Edge(4, 3, 6));

        // 5th vertex
        graph[5].add(new Edge(5, 6, 1));

        // 6th vertex
        graph[6].add(new Edge(6, 5, 1));

        
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,i,vis,-1)){
                    return true;
                }
            }
        }
        return false;
    }
   public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis,int par) {
    // Mark the current node as visited
    vis[curr] = true;


    // Traverse all edges from the current node
    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if (!vis[e.dest]) {
            if( detectCycleUtil(graph, e.dest, vis, curr)){
                return true;
            }

            }
        else if(vis[e.dest] && e.dest!=par){
            return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];//->null arraylist
        creategraph(graph);
        System.out.println(detectCycle(graph));
    }
}
