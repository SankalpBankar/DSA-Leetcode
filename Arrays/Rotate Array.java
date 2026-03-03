import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // in case k > n

        // reverse entire array
        reverse(nums, 0, n - 1);
        // reverse first k elements
        reverse(nums, 0, k - 1);
        // reverse remaining n-k elements
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Example input for testing
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        Solution sol = new Solution();
        sol.rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }
}
