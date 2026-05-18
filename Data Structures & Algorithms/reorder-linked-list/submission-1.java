class Solution {
  public void reorderList(ListNode head) {
    List<Integer> li = new ArrayList<>();
    ListNode temp = head;

    while (temp != null) {
      li.add(temp.val);
      temp = temp.next;
    }

    // two pointers
    int l = 0, r = li.size() - 1;
    temp = head;

    int i = 0;
    // even= li.get(l), odd = li.get(r)
    while (temp != null) {
      if (i % 2 == 0) {
        temp.val = li.get(l);
        l++;
      } else {
        temp.val = li.get(r);
        r--;
      }

      i++;
      temp = temp.next;
    }
  }
}