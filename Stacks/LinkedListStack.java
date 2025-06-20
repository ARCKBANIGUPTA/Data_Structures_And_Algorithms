import java.util.Stack;
//stack implementation Using Linked List
public class LinkedListStack {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static class Stack {
        static Node head =null;

        public static boolean isEmpty(){
            if(head==null){
                return true;
            }
            return false;
        }

        public static void push(int data){
            Node newnode = new Node(data);
            if(isEmpty()){
                head=newnode;
                return;
            }
            newnode.next=head;
            head=newnode;
            return;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            Node temp = head;
            head=head.next;
            temp.next=null;
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
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
