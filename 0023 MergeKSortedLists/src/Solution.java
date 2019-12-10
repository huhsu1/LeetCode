/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = getMin(lists);
        if (head == null) {
            return head;
        }
        head.next = getMin(lists);
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            current.next = getMin(lists);
        }
        return head;
    }
    private ListNode getMin(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        boolean none = true;
        int minVal = 0;
        int minIndex = 0;
        int length = lists.length;
        for (int i = 0; i < length; i++) {
            ListNode cur = lists[i];
            if (cur != null) {
                minVal = cur.val;
                minIndex = i;
                none = false;
                break;
            }
        }
        if (none) {
            return null;
        }
        for (int i = minIndex; i < length; i++) {
            ListNode cur = lists[i];
            if (cur.val < minVal) {
                minVal = cur.val;
                minIndex = i;
            }
        }
        ListNode returnNode = lists[minIndex];
        lists[minIndex] = returnNode.next;
        return returnNode;
    }
}
