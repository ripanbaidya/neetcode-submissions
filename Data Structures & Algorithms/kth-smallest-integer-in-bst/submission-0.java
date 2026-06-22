class Solution {
  public int kthSmallest(TreeNode root, int k) {
    int[] ans = new int[1];
    int[] count = new int[1];
    
    inorder(root, ans, count, k);
    return ans[0];
  }

  private void inorder(TreeNode node, int[] ans, int[] count, int k) {
    if (node == null) 
      return;
    
    inorder(node.left, ans, count, k);
    
    count[0] ++;
    if (count[0] == k) {
      ans[0] = node.val;
      return;
    }

    inorder(node.right, ans, count, k);
  }
}