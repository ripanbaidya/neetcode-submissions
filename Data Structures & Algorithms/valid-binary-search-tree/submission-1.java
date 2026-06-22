class Solution {

    class Info {
        boolean isBST;
        int min;
        int max;

        Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root).isBST;
    }

    private Info dfs(TreeNode node) {

        if (node == null) {
            return new Info(
                true,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE
            );
        }

        Info left = dfs(node.left);
        Info right = dfs(node.right);

        if (!left.isBST || !right.isBST) {
            return new Info(false, 0, 0);
        }

        if (left.max >= node.val ||
            right.min <= node.val) {
            return new Info(false, 0, 0);
        }

        int min = Math.min(node.val, left.min);
        int max = Math.max(node.val, right.max);

        return new Info(true, min, max);
    }
}