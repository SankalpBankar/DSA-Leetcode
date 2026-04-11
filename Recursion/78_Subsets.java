import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        // add current subset
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            // choose
            path.add(nums[i]);

            // explore
            backtrack(nums, i + 1, path, result);

            // backtrack
            path.remove(path.size() - 1);
        }
    }
}