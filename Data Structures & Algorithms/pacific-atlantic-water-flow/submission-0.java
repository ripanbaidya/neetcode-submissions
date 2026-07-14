class Solution {
    // Direction vectors for moving up, down, left, right
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        // Matrices to maintain reachability from each ocean
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // 1. Start DFS from horizontal boundaries (Top and Bottom rows)
        for (int c = 0; c < n; c++) {
            dfs(0, c, heights, pacific);     // Top row touches Pacific
            dfs(m - 1, c, heights, atlantic); // Bottom row touches Atlantic
        }

        // 2. Start DFS from vertical boundaries (Left and Right columns)
        for (int r = 0; r < m; r++) {
            dfs(r, 0, heights, pacific);     // Left column touches Pacific
            dfs(r, n - 1, heights, atlantic); // Right column touches Atlantic
        }

        // 3. Find cells that can flow to both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] visited) {
        // Mark the current cell as reachable from this ocean
        visited[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            // Check boundary limits
            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length) {
                // Climb up: Neighbor must be >= current cell height and not yet visited
                if (!visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    dfs(nr, nc, heights, visited);
                }
            }
        }
    }
}