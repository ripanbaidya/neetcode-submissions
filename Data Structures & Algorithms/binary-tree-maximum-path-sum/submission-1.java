class Solution {
  public int maxPathSum(TreeNode root) {
    int[] ans = new int[]{Integer.MIN_VALUE};
    dfs(root, ans);
    return ans[0];
  }

  private int dfs(TreeNode root, int[] ans) {
    if (root == null)
      return 0;
    
    int leftMax = dfs(root.left, ans);
    int rightMax = dfs(root.right, ans);

    ans[0] = Math.max(ans[0], (root.val + leftMax + rightMax));

    return Math.max(0, root.val + Math.max(leftMax, rightMax));
  }
}