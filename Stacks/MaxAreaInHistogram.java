import java.util.Stack;

public class MaxAreaInHistogram {
    //time commplexity is O(n)
    public static void maxArea(int[] arr) {
        int maxarea = 0;
        int[] nsr = new int[arr.length];
        int[] nsl = new int[arr.length];
        
        // Next Smaller Right (NSR)
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;  // No smaller element to the right
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        
        // Next Smaller Left (NSL)
        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s1.isEmpty() && arr[s1.peek()] >= arr[i]) {
                s1.pop();
            }
            if (s1.isEmpty()) {
                nsl[i] = -1;  // No smaller element to the left
            } else {
                nsl[i] = s1.peek();
            }
            s1.push(i);
        }
        
        // Calculate maximum area
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currarea = height * width;
            maxarea = Math.max(maxarea, currarea);
        }
        System.out.println("The maximum area of rectangle in the histogram is: " + maxarea);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        maxArea(arr);
    }
}
