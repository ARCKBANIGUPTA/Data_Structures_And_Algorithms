public class remove_duplicates {

    public static void remove(String str,StringBuilder newstr,boolean alpha[], int idx){
        //base case
        if(idx == str.length()){
            System.out.println(newstr);
            return;

        }
        char currchar = str.charAt(idx);
        if(alpha[currchar-'a']==true){
            remove(str, newstr, alpha, idx+1);
        }
        else{
            alpha[currchar-'a'] = true;
            remove(str, newstr.append(currchar), alpha, idx+1);
        }
    }
    public static void main(String[] args) {
        String str="appnnacollege";
        boolean alpha[] = new boolean[26];
        remove(str, new StringBuilder(""), alpha, 0);
    }
}
