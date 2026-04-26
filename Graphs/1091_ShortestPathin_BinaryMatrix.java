import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // If start or end is blocked
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        // 8 directions
        int[][] dirs = {
            {1,0},{-1,0},{0,1},{0,-1},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        grid[0][0] = 1; // mark visited (also stores distance)

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            int dist = grid[r][c];

            // Reached destination
            if (r == n - 1 && c == n - 1) {
                return dist;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n 
                    && grid[nr][nc] == 0) {
                    
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = dist + 1; // store distance
                }
            }
        }

        return -1;
    }
}