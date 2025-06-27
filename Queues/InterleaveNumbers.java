import java.util.*;
public class InterleaveNumbers {
    //time complexity -> O(n)
    public static void Interleave(Queue<Integer> q){
        Queue<Integer> qprime = new LinkedList<>();
        //size calculation
        int size = q.size();
        for(int i=0; i<size/2;i++){
            qprime.add(q.remove());
        }
        while(!qprime.isEmpty()){
            q.add(qprime.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        Interleave(q);
        while(!q.isEmpty()){
            System.out.print(" "+q.remove()+" |");
        }
    }
}
