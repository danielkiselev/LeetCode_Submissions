/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        Boolean valid = true;
        Boolean res = true;
        if(head == null){
            return true;
        }
        while(valid){
            stack.push(head.val);
            if(head.next !=null){
                head = head.next;
            }
            else{
                valid = false;
            }
        }
        while(res){
            if(stack.peek() == null){
                return res;
            }
            if(stack.size() == 1){
                return res;
            }
            if(stack.pop().equals(stack.pollLast())){
                if(stack.size() == 0){
                    return res;
                }
                
            }
            else{
                return false;
            }
        }

        return false;
    }
}