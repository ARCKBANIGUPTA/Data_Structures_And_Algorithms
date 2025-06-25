
import java.util.Stack;


public class ReverseAStack {

    public  static void PushBottom(int data,Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        PushBottom(data, s);
        s.push(top);
    }
    
    public static void reverse(Stack<Integer> S){
        //base case
        if(S.isEmpty()){
            return;
        }

        int top = S.pop();
        reverse(S);
        PushBottom(top,S);
    }

    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);
        //output 123
        reverse(S);
        while(!S.isEmpty()){
            System.out.println(S.pop());
        }
    }
}
