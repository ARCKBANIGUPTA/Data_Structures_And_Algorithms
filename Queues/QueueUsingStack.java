import java.util.Stack;
public class QueueUsingStack {
    //Here Push -> O(n)
    // pop -> O(1)
    //peek ->O(1)
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){
            if(s1.isEmpty()){
                s1.push(data);
            }else{
                //transferring s1->s2
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
                // inserting the data in s1
                s1.push(data);
                //transferring s2->s1
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }
        }
        public static int remove(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int val = s1.pop();
            return val;
        }
        public static int front(){
            return s1.peek();
        }
        public static void print(){
            while(!s1.isEmpty()){
                System.out.print(s1.pop()+" ");
            }
        }
    }
    public static void main(String[] args) {
        Queue q2 = new Queue();
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        System.out.println("removed element : "+q2.remove());
        System.out.println("peek element: "+q2.front());
        q2.print();
    }
}
