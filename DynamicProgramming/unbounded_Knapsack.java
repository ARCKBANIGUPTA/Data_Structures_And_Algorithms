public class unbounded_Knapsack {
    
    public static int UknapsackTabulation(int []wt,int val[],int W){
        //Time complexity -> O(n*W)
        int n = val.length;
        int dp [][]= new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v=val[i-1];
                int w = wt[i-1];
                if(w<=j){
                    int includedProfit = v+dp[i][j-w];//we will use ith items not i-1th items
                    int excludedprofit = dp[i-1][j];
                    int FinalProfit = Math.max(includedProfit,excludedprofit);
                    dp[i][j] = FinalProfit;
                }else{
                    int excludedprofit = dp[i-1][j];
                    dp[i][j] = excludedprofit;
                }
            }
        }
        return dp[n][W];
    }
    
    
    public static void main(String[] args) {
        int[] val  = {15, 14, 10, 45, 30};
        int[] wt = { 2,  5,  1,  3,  4};
        int W = 7;
        System.out.println("Maximum value  = " + UknapsackTabulation(wt,val,W));
    }
}
