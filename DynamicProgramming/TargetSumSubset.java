public class TargetSumSubset {
    

    public static boolean TargetSum(int arr[],int sum){
        boolean dp[][] =new boolean[arr.length+1][sum+1];
        for(int i=0;i<arr.length+1;i++){
            dp[i][0] =true;//first column = TRUE
        }

        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j] = true;
                }
                //exclude
                else{
                    if(dp[i-1][j]==true){
                        dp[i][j] = true;
                    }
                }

            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args) {
        int arr[]={4,2,7,1,3};
        int sum = 1;
        System.out.println(TargetSum(arr, sum));
    }
}
