class Solution {
    // If the graph has cycle then false, else true
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];
        
        // 1. Tree can't contain cycle
        if (dfs(0, -1, vis, adj))
            return false; 

        // 2. To become a tree, all nodes must be visited
        for (int v : vis) {
            if (v == 0)
                return false; 
        }

        return true;
    }
    private boolean dfs(int node, int parent, int[] vis, List<List<Integer>> adj) {
        vis[node] = 1;

        for (int nei : adj.get(node)) {
            if (vis[nei] == 0) {
                if (dfs(nei, node, vis, adj))
                    return true;
            } else if (vis[nei] == 1 && nei != parent)
                return true; // cycle
        }

        return false; // no cycle
    }
}
