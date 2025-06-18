public class Palindrome {
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
        Node fast = head;
        while(fast!=null &&  fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static boolean check(){
        if(head == null || head.next==null){
            return true;
        }
        // step1 - find Middle node
        Node midnode = findMid(head);
        // step 2 - reverse the 2nd part
        Node prev=null;
        Node curr=midnode;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        // step 3 - compare
        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;

    } 
    public static void main(String[] args) {
        addFirst(1);
        addFirst(2);
        addFirst(2);
        addFirst(0);
        printLL(head);
        if(check()){
            System.out.println("yes, it is a palindrome");
        }else{
            System.out.println("No,this is not a palindrome");
        }
    }
}
