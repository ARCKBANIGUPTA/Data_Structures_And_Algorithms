public class longest_common_subsequence {
    
    public static int commonSubsequence(String str1,String str2,int n,int m,int dp[][]){
        
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        //same
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            dp[n][m] =commonSubsequence(str1, str2, n-1, m-1, dp)+1;

            return dp[n][m];
        }else{//diff
            dp[n][m]= Math.max(commonSubsequence(str1, str2, n-1, m, dp), commonSubsequence(str1, str2, n, m-1, dp));
            return dp[n][m];
        }
    }

    public static int TabulationCommonSubsequence(String str1,String str2,int n,int m){
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //same
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{//diff
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return dp[n][m];
    }



    public static void main(String[] args) {
        String str1="abcdge";
        String str2="abedg";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println("longest<Memoization>: "+commonSubsequence(str1, str2, n, m, dp));
        System.out.println("longest<Tabulation>: "+TabulationCommonSubsequence(str1, str2, n, m));
    }
}
