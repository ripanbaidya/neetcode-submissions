class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> que = new ArrayDeque<>(); // {row, col, dist}
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 0)
                    que.offer(new int[]{i, j, 0});
            }
        }

        while (!que.isEmpty()) {
            int[] top = que.poll();
            int cr = top[0];
            int cc = top[1];
            int cd = top[2];

            for (int[] dir : DIRS) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                int newDist = cd + 1;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != -1 && 
                grid[nr][nc] == INF) {
                    grid[nr][nc] = newDist;
                    que.offer(new int[]{nr, nc, newDist});
                }
            }
        }
    }
}
