public class Stocks_Cooldown {


    int Stocks(int idx, int buy, int prices[], int dp[][][],int cooldown) {
        if (idx == prices.length) {
            return 0;
        }

        if (dp[idx][buy][cooldown] != -1) {
            return dp[idx][buy][cooldown];
        }

        int profit;
        if (buy == 1) {//buy
           if(cooldown==1){
                profit = Stocks(idx + 1, 1,  prices, dp,0);
           }else{
                profit = Math.max(
                    -prices[idx] + Stocks(idx + 1, 0, prices, dp,0),
                    Stocks(idx + 1, 1,  prices, dp,0)
                );
           }
        } else {//sell
            profit = Math.max(
                prices[idx] + Stocks(idx + 1, 1, prices, dp,1),
                Stocks(idx + 1, 0,  prices, dp,0)
            );
            
        }
        dp[idx][buy][cooldown] = profit;
        return profit;
      
    }

    public static void main(String[] args) {
        int prices[] = {1,2,3,0,2};
        int n = prices.length;

        int dp[][][] = new int[n][2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        Stocks_Cooldown stockTrader = new Stocks_Cooldown();
        int maxProfit = stockTrader.Stocks(0, 1, prices, dp,0);
        System.out.println("Maximum Profit with at most " + maxProfit);
    }

}

