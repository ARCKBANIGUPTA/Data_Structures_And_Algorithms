public class Minimum_paritioning {
    //variation of 0-1 knapsack
    public static int MinDifference(int arr[]){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int W = sum/2;
       
        int dp[][] = new int[n+1][W+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = arr[i-1];
                if(v<=j){
                    //include
                    int inc = v+dp[i-1][j-v];
                    //exclude
                    int exc = dp[i-1][j];
                    dp[i][j] = Math.max(inc, exc);
                }else{
                    int exc = dp[i-1][j];
                    dp[i][j] = exc;
                }
            }
        }
        int set1 = dp[n][W];
        int set2 = sum-set1;
        return Math.abs(set1-set2);
    }

    public static void main(String[] args) {
        int arr[]={1,6,11,5};
        
        System.out.println("Minimum difference is: "+MinDifference(arr));
    }
}
