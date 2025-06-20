import java.util.*;
//Stack implementation using Arraylists
public class ArrayListStacks {
    
    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        } 
        public void push(int data) {
            list.add(data);
        }   
        public int pop() {
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }
        public int peek() {
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size() - 1);
        }
    } 

    public static void main(String[] args) {
        Stack S = new Stack();
        S.push(2);
        S.push(3);
        S.push(6);
        S.push(7);
        S.push(1);

        while (!S.isEmpty()) {
            System.out.println(S.peek());
            S.pop();
        }
    }
}
