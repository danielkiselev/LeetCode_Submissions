/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

    HashMap<Integer,Node> depthMap;
    public Node connect(Node root) {
        if(root == null){
             return null;
        }
        else{
            depthMap = new HashMap<Integer, Node >();
            return trav(root, 0);
        }
    }
    
    private Node trav(Node curr, int depth){
        if(curr.right != null){
            curr.right = trav(curr.right, depth+1);
        }
        if(curr.left != null){
            curr.left = trav(curr.left, depth+1);
        }
        if(depthMap.containsKey(depth)){
            curr.next = depthMap.get(depth);
            depthMap.put(depth, curr);
        }
        else{
            depthMap.put(depth, curr);
            curr.next = null;
        }
        return curr;
    }

}