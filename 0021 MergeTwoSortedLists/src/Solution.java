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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int switchNumber = 0;
        if (l1 != null) {
            switchNumber += 1;
        }
        if (l2 != null) {
            switchNumber += 2;
        }
        switch (switchNumber) {
            case 0:
                return null;
            case 1:
                return l1;
            case 2:
                return l2;
            case 3:
                if (l1.val < l2.val) {
                    ListNode sol = l1;
                    sol.next = mergeTwoLists(l1.next, l2);
                    return sol;
                } else {
                    ListNode sol = l2;
                    sol.next = mergeTwoLists(l1, l2.next);
                    return sol;
                }
            default:
                return null;
        }
    }
}
