/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Integer, Node> nodeIndexOg = new HashMap<Integer, Node>();
    private Node traverse(Node head, int index) {
        Node curr = new Node(head.val);
        head.val = index;
        nodeIndexOg.put(index, curr);
        if(head.next != null){
            curr.next = traverse(head.next, index+1);
        }
        if(head.random != null){
            curr.random = nodeIndexOg.get(head.random.val);
        }
        nodeIndexOg.put(index, curr);
        return curr;
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        return traverse(head, 0);
        
    }
}