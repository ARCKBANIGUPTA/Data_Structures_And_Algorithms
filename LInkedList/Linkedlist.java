public class Linkedlist {
    //basic operations
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

    public static void addLast(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;

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
    public static void addAtIdx(int idx,int data){
        if(head==null){
            System.out.println("ll is empty"
            );
            return;
        }
        Node temp = head;
        for(int i=0;i<idx-1;i++){
            temp=temp.next;
        }
        Node newnode= new Node(data);
        size++;
        newnode.next = temp.next;
        temp.next=newnode;
        
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
    public static int removeFirst(){
        int val;
        if(size==0){
            System.out.println("LL is emppty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            val = head.data;
            head = tail = null;
            size=0;
            return val;
        }else{
            val = head.data;
            head = head.next;
            size--;
            return val;
        }
        
        
    }
    public static int removeLast(){
          int val;
        if(size==0){
            System.out.println("LL is emppty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            val = head.data;
            head = tail = null;
            size=0;
            return val;
        }else{
            //index to delete = size-2
            Node prev = head;
            for(int i=0;i<size-2;i++){
                prev=prev.next;
            }
            val = tail.data;
            prev.next=null;
            tail = prev;
            size--;
            return val;
        }

    }
    
    public static int SeachIterative(int key){
        int idx=0;
        Node temp=head;
        for(int i=0;i<size;i++){
            if(temp.data==key){
                idx++;
                return idx;
            }

        }
        return -1;
    }
    
    public static int SearchRecursion1(int key,int idx,Node next){
        //base case
        if(idx==size){
            return -1;
        }
        //work
        if(next.data==key){
            return idx;
        }
        return SearchRecursion1(key, idx+1, next.next);
    }
    public static int helper(Node head,int key){
        if(head==null){
            return -1;
        }

        if(head.data==key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public static int SearchRecursion2(int key){
        return helper(head, key);
    }
    public static void main(String[] args) {
        addFirst(1);
        addLast(4);
        addFirst(3);
        // printLL(head);
        addAtIdx(2, 8);
        printLL(head);
        // System.out.println("size of LL : "+sizeOfLL());
        // System.out.println("data removed is : "+removeFirst());
        // System.out.println("data removed is : "+removeLast());
        // printLL(head);
        // System.out.println(SeachIterative(10));
        System.out.println(SearchRecursion1(4, 0, head));
        System.out.println(SearchRecursion2(8));
    }
}
