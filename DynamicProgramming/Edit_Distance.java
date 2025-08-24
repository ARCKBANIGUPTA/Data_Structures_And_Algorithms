public class Edit_Distance {
    

    public static int Convert(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        //init
        for(int i=0;i<n+1;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j] = j;
        }

        for(int i =1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //same
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    //add operation
                    int add = dp[i][j-1]+1;
                    //delete operation
                    int delete = dp[i-1][j]+1;
                    //replace operation
                    int replace = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(add, Math.min(delete, replace));
                }

            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(Convert(str1, str2));
    }
}
