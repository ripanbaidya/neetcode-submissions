class Solution {
  
  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    List<List<Integer>> adjList = convertToAdjList(isConnected, n);

    int cnt = 0; // number of provinces
    int[] vis = new int[n];
    
    for (int i = 0; i < n; i ++) {
      if (vis[i] == 0) {
        bfs(i, adjList, vis);
        cnt ++;
      }
    }

    return cnt;
  }


  private List<List<Integer>> convertToAdjList(int[][] edges, int n) {
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < n; i ++) { // O(n)
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i ++) { // O(n^2)
      for (int j = 0; j < n; j ++) {
        // If i -- j connected and not the city connecting to itself
        if (edges[i][j] == 1 && i != j) {
          adj.get(i).add(j);
        }
      }
    }

    return adj;
  } // O(n^2)

  private void bfs(int start, List<List<Integer>> adj, int[] vis) {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(start);
    vis[start] = 1;

    while (!q.isEmpty()) {
      int currNode = q.poll();

      for (int it : adj.get(currNode)) {
        if (vis[it] == 0) {
          q.offer(it);
          vis[it] = 1;
        }
      }
    }
  } // O(V + E)

}