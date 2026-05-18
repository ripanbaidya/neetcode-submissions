class Solution {  
  // brute force
  public ListNode middleNode(ListNode head) {
    int len = getLength(head);
    int mid = len/2;

    for (int i = 0; i < mid; i ++) {
      head = head.next;
    }

    return head;
  }

  private int getLength(ListNode head) {
    int len = 0;
    while (head != null) {
      len ++;
      head = head.next;
    }
    
    return len;
  }
}