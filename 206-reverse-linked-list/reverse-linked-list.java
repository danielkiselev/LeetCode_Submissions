/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {
//     ListNode holder;

//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) {

//             return head;
//         }
//         trav(head).next = null;
//         return holder;

//     }

//     ListNode trav(ListNode n) {
//         if (n.next != null) {
//             ListNode res;
//             res = trav(n.next);
//             res.next = n;
//             return n;

//         } else {
//             holder = n;
//             return n;
//         }

//     }
// }


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