public class Rod_Cutting {

    public static int MaxProfit(int rodLength[],int prf[],int Totallen){
        int n = prf.length;
        int dp[][] = new int[n+1][Totallen+1];
        for(int i=0;i<n+1;i++){
            dp[0][i]=0;//1st row
        }
        for(int j=0;j<Totallen+1;j++){
            dp[j][0]=0;//1st column
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<Totallen+1;j++){
                int p = prf[i-1];
                int l = rodLength[i-1];
                if(l<=j){
                    //include
                    int incPrice = p+dp[i][j-l];
                    //exlude
                    int excPrice = dp[i-1][j];
                    dp[i][j] = Math.max(incPrice,excPrice);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][Totallen];
    }

    public static void main(String[] args) {
        int rodLength[]= {1,2,3,4,5,6,7,8,9,10};
        int prf[] = {2 ,5, 7, 8, 10, 17, 17, 20, 24,30};
        int Totallen = 10;
        System.out.println(MaxProfit(rodLength, prf, Totallen));
    }
}

