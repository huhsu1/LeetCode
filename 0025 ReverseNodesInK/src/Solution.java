/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode last = head;
        ListNode curr = head;
        ListNode first = head;
        // first case
        for (int i = 0; i < k; i++) {
            if (last == null) {
                return head;
            }
            last = last.next;
        }
        while (curr.next != last) {
            curr = curr.next;
            first.next = curr.next;
            curr.next = head;
            head = curr;
            curr = first;
        }
        while (true) {
            for (int i = 0; i < k; i++) {
                if (last == null) {
                    return head;
                }
                last = last.next;
            }
            ListNode pseudoHead = first;
            first = first.next;
            curr = first;
            while (curr.next != last) {
                curr = curr.next;
                first.next = curr.next;
                curr.next = pseudoHead.next;
                pseudoHead.next = curr;
                curr = first;
            }
        }
    }
}
