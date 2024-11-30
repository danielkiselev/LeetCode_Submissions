/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeMap <Integer, Integer> map1 = new TreeMap <Integer, Integer>();//index, value
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sz1 = 0;
    int sz2 = 0;
    if(l1 != null){
        sz1 = trav(l1);
    }
    if(l2 != null){
        sz2 = trav(l2);
    }
    ListNode res = null;
    if(sz1>sz2){
        int carry = 0;
        for(int i = 0; i<sz1; i++){
            int val = map1.get(i) + carry;
            carry = 0;
            if(val>9){
                val-=10;
                ListNode n = new ListNode((val));
                n.next = res;
                res = n;
                carry++;
            }
            else{
                ListNode n = new ListNode((val));
                n.next = res;
                res = n;
            }
        }
        if(carry!=0){
            ListNode n = new ListNode((carry));
            n.next = res;
            res = n;
        }
    }
    else{
        int carry = 0;
        for(int i = 0; i<sz2; i++){
            int val = map1.get(i) + carry;
            carry = 0;
            if(val>9){
                val-=10;
                ListNode n = new ListNode((val));
                n.next = res;
                res = n;
                carry++;
            }
            else{
                ListNode n = new ListNode((val));
                n.next = res;
                res = n;
            }
        }
        if(carry!=0){
            ListNode n = new ListNode((carry));
            n.next = res;
            res = n;
        }
    }
        return res;
    }
    
    private int trav(ListNode curr){
        int index = 0;
        if(curr.next == null){
            if(map1.containsKey(index)){
                int temp = map1.get(index); 
                map1.put(index, temp+curr.val);
            }
            else{
                map1.put(index, curr.val);
            }
            return index+1;
        }
        else{
            index = trav(curr.next);
            if(map1.containsKey(index)){
                int temp = map1.get(index); 
                map1.put(index, temp+curr.val);
            }
            else{
                map1.put(index, curr.val);
            }
            return index+1;
        }
    }
}