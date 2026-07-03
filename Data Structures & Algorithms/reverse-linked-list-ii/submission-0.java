class Solution {
  // optimal

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || head.next == null || left == right)
      return head;

    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode prev = dummy;
    ListNode temp = head;

    ListNode leftPrev = dummy;
    ListNode leftStart = head;
    ListNode rightEnd = head;

    int pos = 1;

    while (temp != null) {
      if (pos == left) {
        leftPrev = prev;
        leftStart = temp;
      }

      if (pos == right) {
        rightEnd = temp;
        break;
      }

      prev = temp; // Keep prev one step behind temp
      temp = temp.next;
      pos++;
    }

    // Detach
    ListNode rightNext = rightEnd.next;
    rightEnd.next = null;

    // Reverse and reconnect
    leftPrev.next = reverse(leftStart);
    leftStart.next = rightNext;

    return dummy.next;
  }

  private ListNode reverse(ListNode head) {
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