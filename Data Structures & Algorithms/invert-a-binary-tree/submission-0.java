class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return root;

    // swap the childrens
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    // perfrom the same recursively for left & right subtree
    invertTree(root.left);
    invertTree(root.right);

    return root;
  }
}