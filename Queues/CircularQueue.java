

public class CircularQueue {
    int arr[];
    int size;
    int rear;
    int front;

    CircularQueue(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
        front = -1;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void add(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        if (isEmpty()) {
            rear = front = 0;
        } else {
            rear = (rear + 1) % size;
        }
        arr[rear] = data;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        int result = arr[front];
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % size;
        }
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return arr[front];
    }


    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.printQueue();
        System.out.println("Removed element: " + q.remove());
        System.out.println("Peek value: " + q.peek());
        q.printQueue();
    }
}
