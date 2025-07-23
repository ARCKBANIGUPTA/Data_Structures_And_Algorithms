import java.util.ArrayList;

public class Operations {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        
        public void add(int data){
            // Add at last index
            arr.add(data);
            int child = arr.size() - 1;
            int par = (child - 1) / 2;


            while (child > 0 && arr.get(par) > arr.get(child)) {
                // Swap
                int temp = arr.get(child);
                arr.set(child, arr.get(par));
                arr.set(par, temp);
                child = par;
                par = (child - 1) / 2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int idx){
            // time complexity -> O(log n)
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int minIdx = idx;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != idx) {
                // Swap
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }

        public int remove(){
            int data = arr.get(0);
            // Step 1 -> Swap first and last index
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            // Step 2 -> Remove the last element
            arr.remove(arr.size() - 1);
            // Step 3 -> Heapify, but only if not empty
            if (!arr.isEmpty()) {
                heapify(0);
            }
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(2);
        h.add(3);
        h.add(1);
        h.add(50);
        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
