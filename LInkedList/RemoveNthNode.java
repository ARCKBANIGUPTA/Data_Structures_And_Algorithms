

public class RemoveNthNode {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;

    }
    public static void printLL(Node head) {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        System.out.print("The Linked list is : ");
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static int sizeOfLL() {
        if (head == null) {
            System.out.println("LL is empty");
            return 0;
        }
        Node temp = head;
        int sizell=0;
        while (temp != null) {

            temp = temp.next;
            sizell++;
        }
        return sizell;
    }
    public static void  deleteNth(int n){
        int sz = sizeOfLL(); 
        if(n == sz){
            head = head.next;
            return;
        }
        int i =1;
        int iTofind = sz-n;
        Node prev=head;
        while(i<iTofind){
            prev = prev.next;i++;
        }
        prev.next=prev.next.next;
        return;
    }
    public static void main(String[] args) {
        addFirst(1);
        addFirst(2);
        addFirst(4);
        addFirst(3);
        printLL(head);
        deleteNth(2);
        printLL(head);
        
    }
}
