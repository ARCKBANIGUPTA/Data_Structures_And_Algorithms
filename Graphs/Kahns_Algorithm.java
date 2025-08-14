import java.util.*;

public class Kahns_Algorithm {
    
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
        // graph[3].add(new Edge(3, 1, 1)); 

    }
    public static void CalculateInDeg(ArrayList<Edge> graph[],int indeg[]){
        
        for(int v=0;v<graph.length;v++){
            for(int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSort(ArrayList<Edge> graph[]){
        int indeg[]=new int[graph.length];
        CalculateInDeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indeg.length;i++){//adding nodes which are already have indegree==0
            if(indeg[i]==0){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+ "  ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];//->null arraylist
        creategraph(graph);
        topSort(graph);
    }
}
