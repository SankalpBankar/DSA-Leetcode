import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        // Base case: if current path length equals input length, we found a permutation
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // Choose
            used[i] = true;
            path.add(nums[i]);

            // Explore
            backtrack(nums, used, path, result);

            // Un-choose (Backtrack)
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
