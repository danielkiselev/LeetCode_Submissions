/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList <ListNode> data = new ArrayList <ListNode>(Arrays.asList(lists));
        if(data.isEmpty()){
            return null;
        }
        return merge(data);
    }
    private ListNode merge(ArrayList <ListNode> lists){
        if(lists.isEmpty()){
            return null;
        }
        else{
            ListNode min = null;
            int minVal = Integer.MAX_VALUE;
            for(ListNode l : lists){
                if(l != null){
                    if(l.val<minVal){
                        minVal = l.val;
                        min = l;
                    }
                }
            }
            if(min == null){
                return null;
            }
            else if(min.next == null){
                lists.remove(min);
                min.next = merge(lists);
                return min;
            }
            else{
                ListNode replacement = min.next;
                lists.remove(min);
                lists.add(replacement);
                min.next = merge(lists);
                return min;
            }
        }
    }
}