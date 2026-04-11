import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index, 
                           List<Integer> path, List<List<Integer>> result) {

        // base case
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {

            // choose
            path.add(candidates[i]);

            // explore (reuse same index allowed)
            backtrack(candidates, target - candidates[i], i, path, result);

            // backtrack
            path.remove(path.size() - 1);
        }
    }
}