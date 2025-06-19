public class MergeSortinLinkedList {
    
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
    public static Node merge(Node head1,Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
            }else{
                temp.next=head2;
                head2=head2.next;
            }
            temp=temp.next;
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
        
    }
    public static Node mergesort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid=findMid(head);
        //left and right part merge sort function call
        Node rightHead = mid.next;
        mid.next=null;
        Node newLeft = mergesort(head);
        Node newRight = mergesort(rightHead);

        //merge of left and right part
        return merge(newLeft,newRight);
    }
    public static void main(String[] args) {
        addFirst(1);
        addFirst(5);
        addFirst(2);
        addFirst(7);
        printLL(head);

        Node head1 = mergesort(head);
        printLL(head1);
    }
}
