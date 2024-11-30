/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head; 
        }
        if(head.val == val){
            if(head.next != null){
                return removeElements(head.next, val);
            }
            else{
                return null;
            }
        }
        else if(head.next != null){
            head.next = removeElements(head.next, val);
            return head;
        }
        return head;
    }
}