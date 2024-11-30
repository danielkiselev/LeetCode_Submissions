/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet <ListNode> data = new HashSet <ListNode>();
        ListNode curr = head;
        while(curr != null){
            if(data.contains(curr)){
                return true;
            }
            else if(curr.next != null){
                data.add(curr);
                curr = curr.next;
            }
            else{
                return false;
            }
            
        }
        return false;
    }
}