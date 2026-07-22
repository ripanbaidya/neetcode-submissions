class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i ++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                ans ++;
            }
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (int nei : adj.get(node)) {
            if (!vis[nei])
                dfs(nei, adj, vis);
        }
    }
}
