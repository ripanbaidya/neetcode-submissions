class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0)
      return null;
    
    ArrayList<Integer> li = new ArrayList<>();
  
    for (ListNode list : lists) {
      while (list != null) {
        li.add (list.val);
        list = list.next;
      }
    }

    Collections.sort(li);

    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    for (int val : li) {
      cur.next = new ListNode(val);
      cur = cur.next;
    }

    return dummy.next;
  }
}