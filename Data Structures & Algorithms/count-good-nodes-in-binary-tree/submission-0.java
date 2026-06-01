class Pair {
  TreeNode node;
  int maxi;

  public Pair (TreeNode node, int maxi) {
    this.node = node;
    this.maxi = maxi;
  }
}

class Solution {
  public int goodNodes(TreeNode root) {
    int count = 0; // result
    Deque<Pair> deq = new ArrayDeque<>();

    if (root == null)
      return count;

    deq.offerLast(new Pair(root, Integer.MIN_VALUE));

    while (!deq.isEmpty()) {
      int size = deq.size();

      for (int i = 0; i < size; i ++) {
        Pair currPair = deq.pollFirst();

        TreeNode currNode = currPair.node;
        int currMaxi = currPair. maxi;

        if (currMaxi <= currNode.val)
          count ++;

        if (currNode.left != null)
          deq.offerLast(new Pair(currNode.left, Math.max(currMaxi, currNode.val)));
        if (currNode.right != null)
          deq.offerLast(new Pair(currNode.right, Math.max(currMaxi, currNode.val)));
      }
    }

    return count;
  }
}