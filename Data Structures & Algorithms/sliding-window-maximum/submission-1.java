class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    // descending order based on value
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    int[] res = new int[nums.length-k+1];
    int it = 0;

    for (int i = 0; i < nums.length; i ++) {
      heap.offer(new int[]{nums[i], i});

      // i-k+1 ... i
      while (heap.peek()[1] <= i-k)
        heap.poll();

      if (i >= k-1)
        res[it ++] = heap.peek()[0];
    }

    return res;
  }
}