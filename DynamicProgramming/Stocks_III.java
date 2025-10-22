public class Stocks_III {


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
                0 + Stocks(idx + 1, 1, cap, prices, dp)
            );
        } else {
            profit = Math.max(
                prices[idx] + Stocks(idx + 1, 1, cap - 1, prices, dp),
                0 + Stocks(idx + 1, 0, cap, prices, dp)
            );
        }

        dp[idx][buy][cap] = profit;
        return profit;
    }

    public static void main(String[] args) {
        int prices[] = {3,3,5,0,0,3,1,4};
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        Stocks_III stockTrader = new Stocks_III();
        int maxProfit = stockTrader.Stocks(0, 1, 2, prices, dp);
        System.out.println("Maximum Profit with at most two transactions: " + maxProfit);
    }
}
