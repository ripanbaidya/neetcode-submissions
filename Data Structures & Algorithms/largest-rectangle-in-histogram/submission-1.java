class Solution {
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] prevSmaller = new int[n];
    int[] nextSmaller = new int[n];

    Deque<Integer> stk = new ArrayDeque<>();
    Arrays.fill(nextSmaller, n);

    // Find the previous smaller
    for (int i = 0; i < n; i ++) {
      while (!stk.isEmpty() && heights[i] <= heights[stk.peek()]) {
        stk.pop();
      }
      prevSmaller[i] = stk.isEmpty() ? -1 : stk.peek();
      stk.push(i);
    }

    stk.clear();

    // Find the next smaller
    for (int i = 0; i < n; i ++) {
      while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
        int idx = stk.pop();
        nextSmaller[idx] = i;
      }
      stk.push(i);
    }

    int maxArea = 0;
    for (int i = 0; i < n; i ++) {
      int w = nextSmaller[i] - prevSmaller[i] - 1;
      maxArea = Math.max(maxArea, heights[i] * w);
    }

    return maxArea;
  }
}