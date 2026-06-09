class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long sum = 0;
        long maxSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            if (i >= k) {
                sum -= nums[i - k];

                freq.put(nums[i - k], freq.get(nums[i - k]) - 1);

                if (freq.get(nums[i - k]) == 0) {
                    freq.remove(nums[i - k]);
                }
            }

            if (i >= k - 1 && freq.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}