public class Stocks_IV {


    int Stocks(int idx, int buy, int cap, int prices[], int dp[][][]) {
        if (idx == prices.length || cap == 0) {
            return 0;
        }

        if (dp[idx][buy][cap] != -1) {
            return dp[idx][buy][cap];
        }

        int profit;
        if (buy == 1) {
            profit = Math.max(
                -prices[idx] + Stocks(idx + 1, 0, cap, prices, dp),
                Stocks(idx + 1, 1, cap, prices, dp)
            );
        } else {
            profit = Math.max(
                prices[idx] + Stocks(idx + 1, 1, cap - 1, prices, dp),
                Stocks(idx + 1, 0, cap, prices, dp)
            );
        }

        dp[idx][buy][cap] = profit;
        return profit;
    }

    public static void main(String[] args) {
        int prices[] = {3,3,5,0,0,3,1,4};
        int n = prices.length;
        int maxTransactions = 6; 
        int dp[][][] = new int[n][2][maxTransactions + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k <= maxTransactions; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        Stocks_IV stockTrader = new Stocks_IV();
        int maxProfit = stockTrader.Stocks(0, 1, maxTransactions, prices, dp);
        System.out.println("Maximum Profit with at most " + maxTransactions + " transactions: " + maxProfit);
    }

   
}
