class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean dfs(TreeNode node, long min, long maxi) {
        if (node == null)
            return true;
        if (!(min < node.val && node.val < maxi))
            return false;
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, maxi);
    }
}
