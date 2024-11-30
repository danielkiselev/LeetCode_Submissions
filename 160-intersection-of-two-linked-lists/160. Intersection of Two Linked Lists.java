/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    HashSet<ListNode> hs;
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null){
            return null;
        }
        if(headB == null){
            return null;
        }
        hs = new HashSet<ListNode>();
        headA = trav(headA);
        return trav(headB);
    }
    
    private ListNode trav(ListNode curr){
        if(hs.contains(curr)){
            return curr;
        }
        else{
            hs.add(curr);
            if(curr.next != null){
                curr = trav(curr.next);
                return curr;
            }
            else{
                return null;
            }
        }
    }
}