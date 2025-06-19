public class ZigZagLL {

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
    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null &&  fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node reverse(Node head){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }
    public static void zigzag(Node Lhead){
        //step1 - find middle
        Node mid = findMid(Lhead);
        Node Rhead = mid.next;
        mid.next=null;
        //step2 - reverse the 2nd part
        Rhead = reverse(Rhead);
        //step3 - alternate merging
        Node nextL=null;
        Node nextR=null;
        while(Lhead!=null && Rhead!=null){
            nextL=Lhead.next;
            Lhead.next= Rhead;
            nextR=Rhead.next;
            Rhead.next = nextL;
            //increment
            Lhead=nextL;
            Rhead=nextR;
        }

    }
    public static void main(String[] args) {
        addFirst(1);
        addFirst(5);
        addFirst(2);
        addFirst(7);
        addFirst(6);
        addFirst(9);
        printLL(head);
        zigzag(head);
        printLL(head);
    }
}
