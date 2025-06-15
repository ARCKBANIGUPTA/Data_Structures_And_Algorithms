class MaxSubArray_PrefixArray {
    public static void main(String[] args) {
        int arrays[] = {1, -2, 6, -1, 3};
        int curr_sum = 0;

        int prefix[] = new int[arrays.length];

        // Compute prefix sum array
        prefix[0] = arrays[0];
        for (int i = 1; i < prefix.length; i++) {  // Fixed the loop condition
            prefix[i] = prefix[i - 1] + arrays[i];
        }

        int max_sub_array = Integer.MIN_VALUE;  // Initialize to smallest possible value

        // Compute maximum subarray sum
        for (int j = 0; j < arrays.length; j++) {  // Fixed the loop condition
            int start = j;
            for (int k = j; k < arrays.length; k++) {  // Fixed the loop condition
                int end = k;
                
                // Compute subarray sum using prefix array
                if (start == 0) {
                    curr_sum = prefix[end];  // Avoid accessing prefix[-1]
                } else {
                    curr_sum = prefix[end] - prefix[start - 1];  // Corrected the subtraction
                }

                // Update max sum
                if (max_sub_array < curr_sum) {
                    max_sub_array = curr_sum;
                }
            }
        }

        System.out.println("Maximum Subarray Sum: " + max_sub_array);
    }
}
