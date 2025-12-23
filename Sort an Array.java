class Solution {
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // move i forward
            do {
                i++;
            } while (nums[i] < pivot);

            // move j backward
            do {
                j--;
            } while (nums[j] > pivot);

            if (i >= j) {
                return j; // partition index
            }

            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pIndex = partition(nums, low, high);
            quickSort(nums, low, pIndex);
            quickSort(nums, pIndex + 1, high);
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}
