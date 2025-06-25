import java.util.*;
public class ValidParentheses {
    
    public static boolean isValid(Stack<Character> s,String str){
         
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            //opening
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }
            //closing
            else{
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek()=='(' && ch == ')') || (s.peek()=='[' && ch == ']') || (s.peek()=='{' && ch == '}')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
        
    }
    public static void main(String[] args) {
       Stack<Character> s = new Stack<>();
        String parentheses = "({[]}()";
        if(isValid( s,parentheses)){
            System.out.println("this string is valid!");
        }else{
            System.out.println("Not valid!");
        }
    }
}
