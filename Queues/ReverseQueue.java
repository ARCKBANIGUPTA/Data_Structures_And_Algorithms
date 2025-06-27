import java.util.*;

public class ReverseQueue {
    //time complexity -> O(n)
    public static void Reverse(Queue<Integer> Q){
        Stack<Integer> S = new Stack<>();
        while(!Q.isEmpty()){
            S.add(Q.remove());
        }
        while(!S.isEmpty()){
            Q.add(S.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        Reverse(q);

        
        System.out.println(q);
    }
}
