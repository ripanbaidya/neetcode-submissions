
class Solution {
  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    // Queue stores each cell as an array: {row, column, time_elapsed}
    Queue<int[]> que = new ArrayDeque<>();
    int fresh = 0;     // Tracks total initial fresh oranges
    int rottened = 0;  // Tracks how many fresh oranges successfully turn rotten

    // Step 1: Scan the grid to count fresh oranges and enqueue all initially rotten oranges
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          fresh++;
        } else if (grid[i][j] == 2) {
          // All initial rotten oranges start spreading at time = 0
          que.offer(new int[]{i, j, 0});
        }
      }
    }

    int miniTime = 0; // Tracks the maximum time required to rot all reachable oranges
    // Coordinate offsets for moving up, down, left, and right
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Step 2: Multi-source BFS traversal
    while (!que.isEmpty()) {
      int[] cell = que.poll();
      int cr = cell[0]; // Current row
      int cc = cell[1]; // Current column
      int ct = cell[2]; // Current time

      // Explore all 4 adjacent neighbors
      for (int[] dir : dirs) {
        int nr = cr + dir[0]; // Neighbor row
        int nc = cc + dir[1]; // Neighbor column
        int nt = ct + 1;      // Neighbor time (current time + 1 minute)

        // Check if the neighbor is within grid bounds and contains a fresh orange
        if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
          que.offer(new int[]{nr, nc, nt}); // Push the newly rotten orange into the queue
          grid[nr][nc] = 2;                  // Mark it as rotten in the grid to avoid revisiting
          rottened++;                        // Increment the count of processed fresh oranges
          miniTime = Math.max(miniTime, nt); // Update the maximum time taken so far
        }
      }
    }

    // Step 3: If we couldn't reach and rot all fresh oranges, return -1; otherwise, return the total time
    return fresh != rottened ? -1 : miniTime;
  }
}