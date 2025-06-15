public class Grid_ways {
    
    public static int count_ways(int n,int m,int row,int col){
        //base case
       if(row==n-1 && col==m-1){
            return 1;
       }else if(row == n || col == m){
            return 0;
       }

        //kaam(work)
        //for right
        int w1 = count_ways(n, m, row, col+1);
        //for down
        int w2 = count_ways(n, m, row+1, col);
        return w1+w2;
    }


    public static void main(String[] args) {
        int n=10;
        int m=3;
        System.out.println(count_ways(n, m, 0, 0));
        
    }
}
