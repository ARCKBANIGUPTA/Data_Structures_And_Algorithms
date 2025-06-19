public class RemoveCycleInLL {
    
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
    public static void RemoveCycle(){
        Node slow = head;
        Node fast = head;
        Node prev=null;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
                
            }
        }
        if(cycle==false){
            return;
        }

        slow=head;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
            
        }
        prev.next = null;
        
    }

    public static void main(String[] args) {
         head = new Node(1);
         Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        printLL(temp);
        RemoveCycle();
        printLL(head);
    }
}
