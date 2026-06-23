class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length != inorder.length)
      return null;

    int n = preorder.length;

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i ++) {
      map.put(inorder[i], i);
    }

    return helper(preorder, 0, n-1, inorder, 0, n-1, map);
  }

  private TreeNode helper (int[] preorder, int preStart, int preEnd, 
    int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
    
    if (preStart > preEnd || inStart > inEnd)
      return null;

    int rootVal = preorder[preStart];
    TreeNode rootNode = new TreeNode(rootVal);

    int inPos = map.get(rootVal);
    int leftSubtreeSize = inPos - inStart;

    // Recursively construct the left and right subtree
    rootNode.left = helper(preorder, preStart+1, preStart+leftSubtreeSize, 
      inorder, inStart, inPos-1, map);
    rootNode.right = helper(preorder, preStart+1+leftSubtreeSize, preEnd, 
      inorder, inPos+1, inEnd, map);

    return rootNode;
  }
}