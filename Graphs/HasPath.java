import java.util.*;

public class HasPath {
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
        graph[0].add(new Edge(0, 1, 5));

        // 1st vertex
        graph[1].add(new Edge(1, 0, 5));

        // 2nd vertex (disconnected)
        graph[2] = new ArrayList<>(); // No edges

        // 3rd vertex
        graph[3].add(new Edge(3, 4, 2));

        // 4th vertex
        graph[4].add(new Edge(4, 3, 2));


    }
    public static boolean hasPath(int src,int dest,ArrayList<Edge>graph[],boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(e.dest, dest, graph, vis)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];//->null arraylist
        creategraph(graph);
        
        System.out.println(hasPath(1, 4, graph, new boolean[V]));
    }
}
