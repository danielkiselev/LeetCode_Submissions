/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode n;
        if(l1.val<=l2.val){
            n = l1;
            if(l1.next == null){
                n.next = l2;
                return n;
            }
            else if(l2 == null){
                return n;
            }
            else{
                n.next = merge(l1.next, l2);
            }
        }
        else{
            n = l2;
            if(l1 == null){
                return n;
            }
            else if(l2.next == null){
                n.next = l1;
                return n;
            }
            else{
                n.next = merge(l2.next,l1);
            }
        }
        return n;
    }
}