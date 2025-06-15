public class freinds_pairing {

    public static int friendsPair(int n){
        //base case
        if(n==1 || n==2){
            return n;
        }

        // return (friendsPair(n-1)+((n-1)*friendsPair(n-2)));
        
        // choice
        int single = friendsPair(n-1);
        //pair up
        int pair = (n-1) * friendsPair(n-2);

        int totalways = single+pair;
        return totalways;
    }
    public static void main(String[] args) {
        System.out.println(friendsPair(3));
    }
}
