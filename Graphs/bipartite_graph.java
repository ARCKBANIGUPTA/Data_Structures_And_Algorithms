import java.util.*;

public class bipartite_graph {
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
        graph[0].add(new Edge(0, 2, 1));

        // 1st vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2nd vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        // 3rd vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4th vertex
        graph[4].add(new Edge(4, 3, 1));

        // 5th vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6th vertex
        graph[6].add(new Edge(6, 5, 1));


    }
    public static boolean isBipartite(ArrayList<Edge> graph[]){//O(V+E)
        int color[] = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            color[i]=-1;
        }
        //-1 -> no color
        //0 -> yellow
        //1 -> blue
        Queue<Integer> q = new LinkedList<>();

        for(int j=0;j<graph.length;j++){
            if(color[j]==-1){
                q.add(j);
                color[j] = 0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int k=0;k<graph[curr].size();k++){
                        Edge e = graph[curr].get(k);
                        if(color[e.dest]==-1){
                            int nexcol = color[curr] == 0 ? 1 : 0;
                            color[e.dest]=nexcol;
                            q.add(e.dest);
                        }else if(color[e.dest]==color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        //if a graph does not have cycles then it is a BIPARTITE GRAPH
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];//->null arraylist
        creategraph(graph);
        if(isBipartite(graph)){
            System.out.println("It is a bipartite graph");
        }else{
            System.out.println("Not a bipratite graph");
        }

    }
}
