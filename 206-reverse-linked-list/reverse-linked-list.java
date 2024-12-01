
class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayDeque<ListNode> holder = new ArrayDeque<ListNode>();
        ListNode curr = head;
        while(curr.next!=null){
            ListNode temp = curr.next;
            curr.next = null;
            holder.push(curr);
            curr = temp;
        }
        head = curr;
        while(!holder.isEmpty()){
            ListNode temp = holder.pop();
            curr.next = temp;
            curr = temp;
        }
        return head;
            
        
    
    }
}