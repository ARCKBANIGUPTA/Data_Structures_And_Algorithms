import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Kruskals_Algo {

    static int n=4;
    static int rank[] = new int[n];
    static int par[] = new int[n];
    
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src = src;
            this.wt = wt;
            this.dest = dest;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt-e2.wt;
        }
    }
    static void createGraph(ArrayList<Edge> edges) {
    //edges
        edges.add(new Edge( 0,  1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3,  30));
        edges.add(new Edge( 1,  3,  40));
        edges.add(new Edge(2,  3,  50));
    }

    

    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }

    }
    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = find(par[x]);//optimized way,direclty stores the leader of the group
    }
    public static void Union(int a,int b){
        int parA = find(a);
        int parB = find(b);
        if(rank[parA]==rank[parB]){
            par[parA] = parB;
            rank[parB]++;
        }else if(rank[parA]<rank[parB]){
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
    }
    public static void MST(ArrayList<Edge> edges,int V){
        init();
        Collections.sort(edges);
        int finalcost=0;
        int count=0;
        for(int i=0;count<V-1;i++){
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
            if(parA!=parB){
                Union(e.src,e.dest);
                finalcost+=e.wt;
                count++;
            }
        }
        System.out.println(finalcost);
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> edges = new ArrayList<>();//->null arraylist
        createGraph(edges);
        MST(edges, V);
    }


}
