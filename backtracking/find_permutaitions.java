public class find_permutaitions {
    
    public static void permutations(String str,String ans){
        //base case
        if(str.length() == 0){
            System.err.println(ans);
            return;
        }
        //kaam
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            // abcd => ab + d
            String newstr = str.substring(0,i) + str.substring(i+1);
            permutations(newstr, ans+curr);
        }
    }

    public static void main(String[] args) {
        permutations("abc", "");
    }
}
