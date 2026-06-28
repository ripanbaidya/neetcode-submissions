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
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
      (a, b) -> Integer.compare(b.dist, a.dist)
    );

    for (int[] point : points) {
      if (point.length < 1) 
        continue; // for safety

      int dist = calcDistance(point[0], point[1]);
      maxHeap.offer(new Pair(dist, point));

      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    int[][] ans = new int[k][2];
    for (int i = 0; i < k; i ++) {
      Pair curr = maxHeap.poll();
      ans[i] = curr.point;
    }

    return ans;
  }
  
  private int calcDistance(int x, int y) {
    return x*x + y*y;
  }
}