public class Disjoint_Sets_Union {
    static int n=7;
    static int rank[] = new int[n];
    static int par[] = new int[n];

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
    public static void main(String[] args) {
        init();
        Union(1, 3);
        System.out.println("Leader is :"+find(3));
        Union(2, 4);
        System.out.println("Leader is :"+find(2));
    }
}
