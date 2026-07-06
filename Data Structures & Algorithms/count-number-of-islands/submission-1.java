class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0)
      return 0;
    
    int m = grid.length;
    int n = grid[0].length;
    int cnt = 0; // number of island

    for (int i = 0; i < m; i ++) {
      for (int j = 0; j < n; j ++) {
        if (grid[i][j] == '1') {
          bfs(grid, i, j, m, n);
          cnt ++;
        }
      }
    }

    return cnt;
  }

  private void bfs(char[][] grid, int startR, int startC, int m, int n) {
    Queue<int[]> que = new LinkedList<>();
    
    // Add starting land cell and mark it as visited
    que.offer(new int[]{startR, startC});
    grid[startR][startC] = '0';

    // dirs[0] = row, dirs[1] = col
    // all four directions - up, down, lefr, right
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!que.isEmpty()) {
      int[] cell = que.poll();
      int r = cell[0];
      int c = cell[1];

      for (int[] dir : dirs) {
        int nr = r + dir[0];
        int nc = c + dir[1];

        if (isSafe(nr, nc, m, n, grid)) {
          que.offer(new int[]{nr, nc});
          grid[nr][nc] = '0';
        }
      }
    }
  }

  private boolean isSafe(int r, int c, int m, int n, char[][] grid) {
    return r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1';
  }
  
}