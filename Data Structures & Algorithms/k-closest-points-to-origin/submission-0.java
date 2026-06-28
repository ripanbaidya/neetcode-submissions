class Solution {
  static class Pair {
    int dist; // store x^2+y^2
    int[] point;

    public Pair (int dist, int[] point){
      this.dist = dist;
      this.point = point;
    }
  }

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(
      (a, b) -> Integer.compare(a.dist, b.dist)
    );

    for (int[] point : points) {
      int dist = calcDistance(point[0], point[1]);
      minHeap.offer(new Pair(dist, point));
    }

    int[][] ans = new int[k][2];
    for (int i = 0; i < k; i ++) {
      Pair curr = minHeap.poll();
      ans[i] = curr.point;
    }

    return ans;
  }
  private int calcDistance(int x, int y) {
    return x*x + y*y;
  }
}