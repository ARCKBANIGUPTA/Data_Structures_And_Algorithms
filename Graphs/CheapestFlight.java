import java.util.*;

public class CheapestFlight {
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
    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int cost,int stops){
            this.v = v;
            this.stops = stops;
            this.cost=cost;
        }
    }

    public static void creategraph(ArrayList<Edge> graph[],int flights[][]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i =0;i<flights.length;i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt = flights[i][2];
            graph[src].add(new Edge(src,dest,wt));
        }
    }

    public static int cheapestRoute(ArrayList<Edge> graph[],int n,int flights[][],int src,int dest,int k){
        int dist[] = new int[n];
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        dist[src] = 0; 

        Queue<Info> q = new LinkedList<>(); 
        q.add(new Info(src,0,0));
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops>k){
                break;
            }
            for(int j=0;j<graph[curr.v].size();j++){
                Edge e = graph[curr.v].get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(curr.cost+wt<dist[v] && curr.stops<=k){
                    dist[v]=dist[u]+wt;
                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dest];
    }

    public static void main(String[] args) {
        int V=4;
        int[][] flights = new int[][] { // fix array initialization
            {0,1,100},
            {1,2,100},
            {2,0,100},
            {1,3,600},
            {2,3,200}
        };
        int src = 0;
        int dst = 3;
        int k=1;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph, flights);
        System.out.println(cheapestRoute(graph, V, flights,src, dst, k));
    }
}
