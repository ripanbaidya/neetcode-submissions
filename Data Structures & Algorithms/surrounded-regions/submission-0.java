class Solution {
  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;

    // Track the cells which are NOT part of a surrounded region (safe cells)
    // 0 Represents Completely surrounded and 1 Represent Connected to the boundry
    int[][] track = new int[m][n];

    // Step 1: Scan top and bottom boundaries
    for (int j = 0; j < n; j++) {
      if (board[0][j] == 'O')
        dfs(0, j, m, n, board, track);
      if (board[m-1][j] == 'O')
        dfs(m-1, j, m, n, board, track);
    }

    // Step 2: Scan left and right boundaries
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O')
        dfs(i, 0, m, n, board, track);
      if (board[i][n-1] == 'O')
        dfs(i, n-1, m, n, board, track);
    }

    // Step 3: Update the board based on the tracking matrix
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (track[i][j] == 0)
          board[i][j] = 'X'; // Completely surrounded
        else
          board[i][j] = 'O'; // Connected to boundary, remains 'O'
      }
    }
  }

  private void dfs(int r, int c, int m, int n, char[][] board, int[][] track) {
    // Base case: Out of bounds, hit an 'X', or already tracked
    if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] == 'X' || track[r][c] == 1)
      return;

    track[r][c] = 1; // Mark as safe (not part of a surrounded region)

    // Explore 4 directional neighbors
    dfs(r-1, c, m, n, board, track); // up
    dfs(r+1, c, m, n, board, track); // down
    dfs(r, c-1, m, n, board, track); // left
    dfs(r, c+1, m, n, board, track); // right
  }
}