import java.util.ArrayList;

public class Bellmen_ford_Algorithm {
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


    public static void shortestPath(ArrayList<Edge> graph[],int src){//O(E*V)
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        //algo
        for(int i =0;i<V;i++){
            for(int j=0;j<graph.length;j++){//O(E)
                for(int k=0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u]+wt<dist[v] && dist[u]!=Integer.MAX_VALUE){
                        dist[v] = dist[u]+wt;
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+"  ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];//->null arraylist
        creategraph(graph);
        shortestPath(graph, 1);
    }
}
