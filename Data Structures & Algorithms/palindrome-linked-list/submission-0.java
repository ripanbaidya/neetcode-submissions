/**
 * brute force
 * time = O(n)
 * space = O(n)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> li = new ArrayList<>();
        while (head != null) {
            li.add(head.val);
            head = head.next;
        }

        return isListPalindrome(li);
    }

    private boolean isListPalindrome(List<Integer> li) {
        int l = 0, r = li.size() - 1;

        while (l < r) {
            if (li.get(l) != li.get(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}