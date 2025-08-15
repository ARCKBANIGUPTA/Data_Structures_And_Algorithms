import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstras_Algorithm {
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
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair(int n,int path){
            this.path = path;
            this.n = n;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        // 0th vertex
        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 3));

        // 1st vertex
        graph[1].add(new Edge(1, 0, 4));
        graph[1].add(new Edge(1, 3, 2));
        graph[1].add(new Edge(1, 4, 7));

        // 2nd vertex
        graph[2].add(new Edge(2, 0, 3));
        graph[2].add(new Edge(2, 4, 4));

        // 3rd vertex
        graph[3].add(new Edge(3, 1, 2));
        graph[3].add(new Edge(3, 5, 1));

        // 4th vertex
        graph[4].add(new Edge(4, 1, 7));
        graph[4].add(new Edge(4, 2, 4));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 5));

        // 5th vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 2));

        // 6th vertex
        graph[6].add(new Edge(6, 4, 5));
        graph[6].add(new Edge(6, 5, 2));


    }
    public static void shortestPath(ArrayList<Edge> graph[],int src ){//O(V+ElogV)
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();    
            if(!vis[curr.n]){
                vis[curr.n] = true;
                for(int k=0;k<graph[curr.n].size();k++){
                    Edge e = graph[curr.n].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v] = dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<graph.length;i++){
            System.out.print(dist[i]+"  ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];//->null arraylist
        creategraph(graph);
        int src=0;
        shortestPath(graph, src);
    }
}
