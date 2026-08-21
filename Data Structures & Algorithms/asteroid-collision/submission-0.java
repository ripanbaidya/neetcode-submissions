class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stk = new ArrayDeque<>();
    for (int a : asteroids) {
      while (!stk.isEmpty() && stk.peek() > 0 && a < 0) {
        int diff = a + stk.peek();

        if (diff > 0) {
          a = 0;
        } else if (diff < 0) {
          stk.pop();
        } else {
          a = 0;
          stk.pop();
        }
      }
      if (a != 0)
        stk.push(a);
    }

    int[] ans = new int[stk.size()];
    for (int i = ans.length - 1; i >= 0; i--) {
      ans[i] = stk.pop();
    }
    return ans;
  }
}