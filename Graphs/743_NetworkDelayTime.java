import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Build graph
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] t : times) {
            graph[t[0]].add(new int[]{t[1], t[2]});
        }

        // Step 2: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 3: Min Heap {node, distance}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        pq.offer(new int[]{k, 0});

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if (time > dist[node]) continue;

            for (int[] nei : graph[node]) {
                int next = nei[0];
                int w = nei[1];

                if (dist[next] > time + w) {
                    dist[next] = time + w;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        // Step 5: Find max time
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}