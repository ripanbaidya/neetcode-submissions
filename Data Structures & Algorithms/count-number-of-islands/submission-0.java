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
          dfs(grid, i, j, m, n);
          cnt ++;
        }
      }
    }

    return cnt;
  }

  private void dfs(char[][] grid, int r, int c, int m, int n) {
    // If, out of bounds OR already visited
    if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0')
      return;

    // Land which are visited, we are marking that at '0'
    // Just to reduce extra space
    grid[r][c] = '0';

    dfs(grid, r-1, c, m, n); // up
    dfs(grid, r+1, c, m, n); // down
    dfs(grid, r, c-1, m, n); // left
    dfs(grid, r, c+1, m, n); // right
  }
}