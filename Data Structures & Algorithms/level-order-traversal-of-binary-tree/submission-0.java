class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null)
      return res;

    Deque<TreeNode> deq = new ArrayDeque<>();
    deq.offerLast(root);

    while (!deq.isEmpty()) {
      int size = deq.size();

      List<Integer> li = new ArrayList<>();
      for (int i = 0; i < size; i ++) {
        TreeNode currNode = deq.pollFirst();
        
        if (currNode.left != null)
          deq.offerLast(currNode.left);
        if (currNode.right != null)
          deq.offerLast(currNode.right);

        li.add(currNode.val);
      }
      res.add(li);
    }

    return res;
  }
}