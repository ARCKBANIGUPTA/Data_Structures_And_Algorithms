

public class QueuesLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next =null;
        }
    }
    static class Queue{
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            if(head == null && tail==null){
                return true;
            }
            return false;
        }
        //isFull is not required for linkedlists implementation of queues
        public static void add(int data){
            Node newnode = new Node(data);

            if(head==null){
                head = tail = newnode;
                return;
            }
            tail.next= newnode;
            tail=newnode;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;

            }
            int val = head.data;
            if(head==tail){
                head=tail=null;
            }else{
                head=head.next;
            }
            return val;
            
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            return head.data;
        }
        public static void printQueue(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q1.printQueue();
        System.out.println("Removed element is : "+q1.remove());
        System.out.println("Peek element is : "+q1.peek());
        q1.printQueue();
    }
}
