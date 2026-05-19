class Solution {
  public Node copyRandomList(Node head) {
    Map<Node, Node> oldToCopy = new HashMap<>();
    oldToCopy.put(null, null);

    Node cur = head;
    while (cur != null) {
      Node copy = new Node(cur.val);
      oldToCopy.put(cur, copy);
      cur = cur.next;
    }

    // conncet nodes
    cur = head;
    while (cur != null) {
      Node copy = oldToCopy.get(cur);
      copy.next = oldToCopy.get(cur.next);
      copy.random = oldToCopy.get(cur.random);

      cur = cur.next;
    }

    return oldToCopy.get(head);
  }
}