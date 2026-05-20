class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 1) 
      return head;
    
    ListNode curr = head;
    ListNode newHead = null;
    ListNode prevTail = null;

    while (curr != null) {
      ListNode kthNode = moveKStep(curr, k);

      if (kthNode == null) {
        if (prevTail != null)
          prevTail.next = curr;
        break;
      }

      ListNode nextGroup = kthNode.next;
      kthNode.next = null;

      // Reverse current k group
      ListNode revHead = reverseList(curr);

      // Set the newHead once
      if (newHead == null)
        newHead = revHead;

      // connect previous group
      if (prevTail != null) 
        prevTail.next = revHead;

      // Move prevTail to the end of reversed group
      prevTail = curr;

      // Connect tail to new group
      curr.next = nextGroup;

      // Move to next group
      curr = nextGroup;
    }

    return newHead;
  }

  private ListNode reverseList(ListNode node) {
    ListNode prev = null;
    while (node != null) {
      ListNode front = node.next;
      node.next = prev;
      prev = node;
      node = front;
    }

    return prev;
  } 

  private ListNode moveKStep(ListNode node, int k) {
    while (node != null && --k > 0) {
      node = node.next;
    }

    return node;
  }
}