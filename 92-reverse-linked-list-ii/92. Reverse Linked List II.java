/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean start = false;
    boolean rev = false;
    ArrayDeque <ListNode> data = new ArrayDeque <ListNode>();
    int m;
    int n;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }
        this.m = m;
        this.n = n;
        return trav(head, 0);
        
        
        
    }
    
    private ListNode trav(ListNode curr, int index){
        if(!data.isEmpty()){
                    System.out.println("index: "+ index+"  | data: "+ data.peek().val);


        }
        index++;
        if(start){
            data.add(curr);
            if(index == n){
                rev = true;
                ListNode replacement = new ListNode(data.poll().val);
                replacement.next = curr.next;
                return replacement;
            }
        }
        else if(index == m){
            start = true;
            data.add(curr);
        }
        if(curr.next != null){
            curr.next = trav(curr.next, index);
        }
        if(rev){
            if(data.isEmpty()){
            
            }
            else{
                ListNode replacement = new ListNode(data.poll().val);
                replacement.next = curr.next;
                return replacement;
            }

        }
        return curr;
        
    }
}