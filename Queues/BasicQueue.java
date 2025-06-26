
public class BasicQueue{

    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n){
            arr = new int[n];
            size =n;
            rear=-1;
        }
        public static boolean isEmpty(){
            return rear==-1;
        }
        public static void add(int data){
            if(rear == size-1){
                return;//full condition
            }
            rear++;
            arr[rear]=data;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;

            }
            else{
                int front = arr[0];
                for(int i=0;i<rear;i++){
                    arr[i] = arr[i+1];
                }
                rear--;
                return front;
            }
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            else{
                return arr[0];
            }
        }
    }
    public static void main(String[] args) {
        Queue Q = new Queue(5);
        Q.add(1);
        Q.add(2);
        Q.add(3);
        Q.add(4);
        Q.add(5);
        for(int i=0;i<Q.size;i++){
            System.out.print(Q.arr[i]+" ");
        }
        System.out.println();
         System.out.println("Removed element: "+Q.remove());
          System.out.println("Peek value: "+Q.peek());
    }
}