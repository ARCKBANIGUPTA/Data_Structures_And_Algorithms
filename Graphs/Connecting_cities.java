import java.util.*;
public class Connecting_cities {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.wt=wt;
            this.dest=dest;
            this.src=src;
        }
    }
    static class Pair implements Comparable<Pair>{
        int vertex;
        int cost;
        public Pair(int v,int c){
            this.vertex = v;
            this.cost=c;

        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;

        }
    }

    public static void CreateGraph(ArrayList<Edge> graph[],int cities[][]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int j=0;j<cities.length;j++){
            for(int k=0;k<cities[j].length;k++){
                if(cities[j][k]!=0){
                    graph[j].add(new Edge(j,k,cities[j][k]));
                }
            }
        }
    }

    public static void ConnectingPaths(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int finalCost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.vertex]){
                vis[curr.vertex]=true;
                finalCost+=curr.cost;
                System.out.print(curr.vertex+"->"+curr.cost+"  ");
                
                for(int i=0;i<graph[curr.vertex].size();i++){
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }
        System.out.println();
        System.out.println("Total cost: "+finalCost);
    }

    public static void main(String[] args) {
        int V =5;
        ArrayList<Edge> [] graph = new ArrayList[V];
        int cities[][] = {
                        {0, 1, 2, 3, 4},
                        {1, 0, 5, 0, 7},
                        {2, 5, 0, 6, 0},
                        {3, 0, 6, 0, 0},
                        {4, 7, 0, 0, 0}};

        CreateGraph(graph,cities);
        ConnectingPaths(graph);
    }
}
