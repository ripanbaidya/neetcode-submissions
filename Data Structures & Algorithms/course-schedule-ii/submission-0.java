class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }
    int[] inDegree = new int[numCourses];
    for (int[] edge : prerequisites) {
      adj.get(edge[1]).add(edge[0]);
      inDegree[edge[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    int[] order = new int[numCourses];
    int it = 0;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      order[it ++] = node;

      // Reduce in-degree for all adjacent neighbors
      for (int nei : adj.get(node)) {
        inDegree[nei]--;
        // If in-degree becomes 0, add it to the queue
        if (inDegree[nei] == 0) {
          queue.add(nei);
        }
      }
    }

    return it == numCourses ? order : new int[]{};
  }
}