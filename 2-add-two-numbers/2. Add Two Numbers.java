/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        ListNode curr1 = l1;
        while(true){
            sb1.append(Integer.toString(curr1.val));
            if (curr1.next != null){
                curr1 = curr1.next;
            }
            else{
                break;
            }
        }
        sb1.reverse();
        StringBuilder sb2 = new StringBuilder();
        ListNode curr2 = l2;
        while(true){
            sb2.append(Integer.toString(curr2.val));
            if (curr2.next != null){
                curr2 = curr2.next;
            }
            else{
                break;
            }
        }
        sb2.reverse();
        String Temp1 = sb1.toString();
        String Temp2 = sb2.toString();
        BigInteger b1 = new BigInteger(Temp1);
        BigInteger b2 = new BigInteger(Temp2);
        BigInteger b3 = b1.add(b2);
        String s = b3.toString();
        int offSet = s.length();
        ListNode root = new ListNode(Integer.parseInt(s.substring(offSet-1,offSet)));
        ListNode curr3 = root;
        offSet-=1;
        while(offSet>0){
            ListNode temp = new ListNode(Integer.parseInt(s.substring(offSet-1,offSet)));
            offSet-=1;
            curr3.next = temp;
            curr3 = temp;
        }
        return root;
    }
}