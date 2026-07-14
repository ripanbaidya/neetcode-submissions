class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        // Step 2: Push all nodes with in-degree 0 into a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int finish = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            finish++;

            // Reduce in-degree for all adjacent neighbors
            for (int nei : adj.get(node)) {
                inDegree[nei]--;
                // If in-degree becomes 0, add it to the queue
                if (inDegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }

        return finish == numCourses;
    }
}
