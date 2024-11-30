/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    Integer counter = null;
    int n;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;
        return Trav(head);
    }
    
    private ListNode Trav(ListNode curr){
        ListNode nextTrav = null;
        if(curr.next != null){
            nextTrav = Trav(curr.next);
            curr.next = nextTrav;
            counter++;
        }
        else{
            counter = 1;
        }
        if(counter == n){
            return nextTrav;
        }
        else{
            return curr;
        }
    }
}