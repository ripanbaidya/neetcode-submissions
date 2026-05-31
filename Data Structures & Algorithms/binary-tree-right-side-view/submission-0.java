class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightView = new ArrayList<>();
    if (root == null)
      return rightView;
    
    ArrayDeque<TreeNode> deq = new ArrayDeque<>();
    deq.offerLast(root);

    while (!deq.isEmpty()) {
      int size = deq.size();
      for (int i = 0; i < size; i ++) {
        TreeNode curr = deq.pollFirst();

        if (curr.left != null)
          deq.offerLast(curr.left);
        if (curr.right != null)
          deq.offerLast(curr.right);

        // every last node of any particular level would part of right view
        if (i == size-1)
          rightView.add(curr.val);
      }
    }
    
    return rightView;
  }
}