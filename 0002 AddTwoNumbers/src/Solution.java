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

    // Code Starts Here
    private boolean carry = false;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (!carry && l1 == null && l2 == null) {
            return null;
        }
        int val = 0;
        if (l1 != null) {
            val += l1.val;
        }
        if (l2 != null) {
            val += l2.val;
        }
        if (carry) {
            val += 1;
        }
        if (val / 10 != 0) {
            val = val % 10;
            carry = true;
        } else {
            carry = false;
        }
        ListNode returnNode = new ListNode(val);
        returnNode.next = addTwoNumbers(l1.next, l2.next);
        return returnNode;
    }

}