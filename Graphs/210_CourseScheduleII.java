import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        // Step 2: Queue for indegree 0
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: Process
        int[] order = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            order[index++] = course;

            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        // Step 4: Check cycle
        if (index != numCourses) {
            return new int[0]; // cycle
        }

        return order;
    }
}