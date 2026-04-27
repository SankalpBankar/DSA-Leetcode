class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // position to place next non-zero

        // Step 1: Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // Step 2: Fill remaining with zeros
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}