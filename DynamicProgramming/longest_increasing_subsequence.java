import java.util.Arrays;
import java.util.HashSet;
public class longest_increasing_subsequence {

    public static int LCS(int arr1[],int arr2[]){//O(n*m)
        int n = arr1.length;
        int m = arr2.length;
        int dp[][]= new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //same
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    
    public static int LIS(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int arr2[]=new int[set.size()];
        int i=0;
        for (Integer num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);
        return LCS(arr,arr2);
    }

    public static void main(String[] args) {
        int arr[]={50,30,10,7,40,90};
        System.out.println(LIS(arr));
    }
}
