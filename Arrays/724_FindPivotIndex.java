class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        // Step 1: find total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Step 2: find pivot
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}