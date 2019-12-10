class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = head;
        ListNode behind = head;
        for (int i = 0; i < n - 1; i++) {
            ahead = ahead.next;
        }
        if (ahead.next == null) {
            return head.next;
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return head;
    }
}
