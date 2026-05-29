class Solution {
  public boolean isBalanced(TreeNode root) {
    return dfs(root) != -1;
  }

  private int dfs(TreeNode root) {
    if (root == null)
      return 0;

    int leftHeight = dfs(root.left); 
    int rightHeight = dfs(root.right);

    if (Math.abs(leftHeight - rightHeight) > 1)
      return -1;
    if (leftHeight == -1 || rightHeight == -1)
      return -1;

    return 1 + Math.max(leftHeight, rightHeight);
  }
}