class Solution {
  // Optimal
  // time - O(n), space - O(1)
  public boolean isPalindrome(ListNode head) {
    ListNode mid = getMiddle(head);
    ListNode revHead = reverseList(mid);

    ListNode cur = head;
    while (cur != mid) {
      if (cur.val != revHead.val)
        return false;

      cur = cur.next;
      revHead = revHead.next;
    }

    return true;
  }

  private ListNode getMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode front = head.next;
      head.next = prev;
      prev = head;
      head = front; 
    }
    return prev;
  }
}