import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1];
            graph.get(b).add(a); // b → a
            indegree[a]++;
        }

        // Step 2: Add nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: BFS
        int count = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            count++;

            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return count == numCourses;
    }
}