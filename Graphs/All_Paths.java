import java.util.ArrayList;

public class All_Paths {
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
        graph[3].add(new Edge(3, 1, 1)); 
    }

   public static void findPath(ArrayList<Edge>[] graph, int src,int dest,String path) {//O(V^2)
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            findPath(graph, e.dest, dest, path+src);

        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];//->null arraylist
        creategraph(graph);
        
        findPath(graph, 1,3 , "");
    }

}
