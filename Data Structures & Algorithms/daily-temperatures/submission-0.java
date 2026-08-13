class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] ans = new int[n];

    Deque<Integer> stk = new ArrayDeque<>();
    
    for (int i = 0; i < n; i ++) {
      while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
        int idx = stk.pop();
        ans[idx] = i - idx;
      }

      stk.push(i);
    }

    return ans;
  }
}