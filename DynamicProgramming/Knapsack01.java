
public class Knapsack01 {


    public static int knapsackTabulation(int []wt,int val[],int W){
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
                    int includedProfit = v+dp[i-1][j-w];
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
    public static int knapsack(int[] wt, int[] val, int idx, int W,int dp[][]) {
        //Time complexity(only recursion) -> O(2^n)
        //Time Complexity(Memoization) -> O(n*W)
        // Base case: no items left or no capacity
        if (idx == 0 || W == 0) {
            return 0;
        }
        if(dp[idx][W]!=-1){
            return dp[idx][W];
        }
        // If current item fits
        if (wt[idx - 1] <= W) {
            // Include it
            int include = val[idx - 1] + knapsack(wt, val, idx - 1, W - wt[idx - 1],dp);
            // Exclude it
            int exclude = knapsack(wt, val, idx - 1, W,dp);
            dp[idx][W] = Math.max(include, exclude);
            return dp[idx][W];
        }
        else{
            // Otherwise skip the item
            dp[idx][W] = knapsack(wt, val, idx - 1, W,dp);
            return dp[idx][W];
        }
        
    }

    public static void main(String[] args) {
        int[] val  = {15, 14, 10, 45, 30};
        int[] wt = { 2,  5,  1,  3,  4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int best = knapsack(wt, val, wt.length, W,dp);
        System.out.println("Maximum value {Memoization} = " + best);
        System.out.println("Maximum value {Tabulation} = " + knapsackTabulation(wt,val,W));
    }
}
