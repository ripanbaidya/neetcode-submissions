class Solution {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;

    Deque<Integer> stk = new ArrayDeque<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < m; i++) {
      while (!stk.isEmpty() && nums2[i] > nums2[stk.peek()]) {
        int idx = stk.pop();
        map.put(nums2[idx], nums2[i]);
      }
      stk.push(i);
    }

    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = map.getOrDefault(nums1[i], -1);
    }
    return ans;
  }
}