class Solution {
  public Node connect(Node root) {
    if (root == null)
      return null;

    Queue<Node> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      // total nodes of any level, at specific time
      int totalNodes = q.size();

      for (int i = 0; i < totalNodes; i ++) {
        Node currNode = q.poll();

        if (currNode.left != null)
          q.offer(currNode.left);
        if (currNode.right != null)
          q.offer(currNode.right);
        
        // connect next pointer connects to next right node
        currNode.next = i+1 < totalNodes ? q.peek() : null;
      }
    }

    return root;
  } 
}