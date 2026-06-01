class Solution {
  public int goodNodes(TreeNode root) {
    int[] res = new int[1];
    dfs(root, Integer.MIN_VALUE, res);
    return res[0];
  }
  private void dfs(TreeNode root, int maxSeenSoFar, int[] res) {
    if (root == null)
      return;
    if (root.val >= maxSeenSoFar)
      res[0] ++;

    dfs(root.left, Math.max(maxSeenSoFar, root.val), res); 
    dfs(root.right, Math.max(maxSeenSoFar, root.val), res); 
  }
}