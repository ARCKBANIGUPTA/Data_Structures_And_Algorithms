public class DoublyLL {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data){
        Node newnode = new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }
    public static void addLast(int data){
        Node newnode = new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.prev=tail;
        tail.next=newnode;
        newnode.next=null;
        tail=newnode;

    }
    public static int removeFirst(){
        if(head==null){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val = head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;

    }
    public static void printLL(Node head) {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        System.out.print("The Linked list is : ");
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static Node reverse(){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            curr.prev=next;
            //updation
            prev = curr;
            curr=next;
        }
        return prev;
    }
    public static void main(String[] args) {
        addFirst(2);
        addLast(3);
        addFirst(54);
        addFirst(35);
        printLL(head);

        printLL(reverse());
    }
}
