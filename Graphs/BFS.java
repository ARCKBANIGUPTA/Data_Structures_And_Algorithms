import java.util.*;
public class BFS {
    
    
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

    public static void bfs(ArrayList<Edge> graph[]){//O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(1);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+"  ");
                vis[curr] = true;
                for(int j=0;j<graph[curr].size();j++){
                    Edge e = graph[curr].get(j);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];//->null arraylist
        creategraph(graph);
        bfs(graph);

    }
}
