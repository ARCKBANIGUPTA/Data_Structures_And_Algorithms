import java.util.*;

public class Prims_Algorithm {
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
    static class Pair implements Comparable<Pair>{
        int vertex;
        int cost;
        public Pair(int vertex,int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    public static void MST(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int finalCost =0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.vertex]){
                vis[curr.vertex] = true;
                finalCost += curr.cost;
                for(int i=0;i<graph[curr.vertex].size();i++){
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }
        System.out.println(finalCost);
    }


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];//->null arraylist
        creategraph(graph);
        MST(graph);
    }
}
