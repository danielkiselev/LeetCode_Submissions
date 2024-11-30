/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode root;
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        trav(head).next = null;
        return root;
    }
    
    private ListNode trav(ListNode curr){
        ListNode res;
        if(curr.next != null){
            res = trav(curr.next);
            res.next = curr;
            return res.next;
        }
        root = curr;
        return curr;
    }
}