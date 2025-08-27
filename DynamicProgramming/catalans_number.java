import java.util.Arrays;

public class catalans_number {
    
    public static int Calculate(int n,int dp[]){
        
        
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans+= Calculate(i,dp) * Calculate(n-i-1,dp);
        }
        dp[n]=ans;
        return ans;
    }
    public static int CatalansTabulation(int n){
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            for( int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        int n=10;
        int dp[] =new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Memoization: "+Calculate(n,dp));
        System.out.println("Tabulation: "+CatalansTabulation(n));
    }
}
