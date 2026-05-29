class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1]; // maximum diameter
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if (root == null) 
            return 0;
        
        int leftHeight = dfs(root.left, res);
        int rightHeight = dfs(root.right, res);
        
        // calculating maximum diameter
        res[0] = Math.max(res[0], (leftHeight + rightHeight));
        // return the height of the binary tree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
