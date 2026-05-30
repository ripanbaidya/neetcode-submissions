class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    ArrayList<TreeNode> pPath = new ArrayList<>();
    ArrayList<TreeNode> qPath = new ArrayList<>();

    getRootToTargetPath(root, p.val, pPath);
    getRootToTargetPath(root, q.val, qPath);

    TreeNode lca = null;

    int len = Math.min(pPath.size(), qPath.size());

    for (int i = 0; i < len; i++) {
      if (pPath.get(i) == qPath.get(i)) {
        lca = pPath.get(i);
      } else {
        break;
      }
    }

    return lca;
  }

  private boolean getRootToTargetPath(TreeNode root, int targetVal, ArrayList<TreeNode> path) {
    if (root == null) {
      return false;
    }

    path.add(root);

    if (root.val == targetVal) {
      return true;
    }

    if (getRootToTargetPath(root.left, targetVal, path)
        || getRootToTargetPath(root.right, targetVal, path)) {
      return true;
    }

    path.remove(path.size() - 1); // backtrack
    return false;
  }
}