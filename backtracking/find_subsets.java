

public class find_subsets {

    public static void subsets(String str,int idx,String temp){
        //base case
        if(idx == str.length()){
            System.err.println(temp);
            return;
        }
        
        //kaam
        //if yes
        subsets(str,idx+1,temp+str.charAt(idx));
        //if no
        subsets(str, idx+1, temp);

    }

    public static void main(String[] args) {
        String str = "abcdefs";
        subsets(str,0,"");
    }
}
