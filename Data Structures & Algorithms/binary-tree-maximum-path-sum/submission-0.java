class Solution {
    int maxi = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxi;
    }
    private int getMax(TreeNode root) {
        if (root == null) 
            return 0;
        
        int left = getMax(root.left);
        int right = getMax(root.right);
        int path = root.val + Math.max(left, right);
        return Math.max(0, path);
    }
    private void dfs(TreeNode root) {
        if (root == null)
            return;
        
        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);
        
        maxi = Math.max(maxi, (leftMax + rightMax + root.val));
        dfs(root.left);
        dfs(root.right);
    }
}
