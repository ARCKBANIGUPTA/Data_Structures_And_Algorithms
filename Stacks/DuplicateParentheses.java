import java.util.Stack;
public class DuplicateParentheses {
    //Time complexity is of O(n)
    public static boolean isDuplicate(String str){
        Stack<Character>  s = new Stack<>();

        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                int count =0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b)+(c+d))";
        String str1 = "((A-B))";
        if(isDuplicate(str1)){
            System.out.println("This string has duplicate parentheses");
        }else{
            System.out.println("This string does not have duplicate parentheses");
        }
    }
}
