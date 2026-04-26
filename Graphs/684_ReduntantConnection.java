class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        // initialize
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                return edge; // cycle found
            }

            parent[pu] = pv; // union
        }

        return new int[0];
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }
}