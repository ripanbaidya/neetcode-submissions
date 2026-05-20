class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0)
      return null;
    
    while (lists.length > 1) {
      List<ListNode> mergedLists = new ArrayList<>();

      for (int i = 0; i < lists.length; i += 2) {
        ListNode l1 = lists[i];
        ListNode l2 = (i+1) < lists.length ? lists[i+1] : null;

        mergedLists.add(mergeList(l1, l2));
      }
      lists = mergedLists.toArray(new ListNode[0]);
    }
  
    return lists[0];   
  }

  private ListNode mergeList(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    
    cur.next = l1 == null ? l2 : l1;
    return dummy.next;
  }
}