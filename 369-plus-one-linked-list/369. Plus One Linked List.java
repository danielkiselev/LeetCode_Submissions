/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        
        ListNode curr = head;  
        if(curr == null){
            return head;
        }
        curr = trav(curr);
        if(curr.val>=10){
            ListNode n = new ListNode(1);
            curr.val -=10;
            n.next = curr;
            return n;
        }
        return curr;
    }
    
    public ListNode trav(ListNode curr){
        if(curr.next == null){
                curr.val += 1;
                return curr;
        }
        else{
            curr.next = trav(curr.next);
            if(curr.next.val>=10){
                curr.next.val-=10;
                curr.val +=1;
            }
            return curr;
        }
    }
}