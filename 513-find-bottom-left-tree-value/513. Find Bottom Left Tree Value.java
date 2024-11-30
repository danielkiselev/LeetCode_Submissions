/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeMap <Integer,TreeNode> tm = new TreeMap <Integer,TreeNode>();
    int max = 0;
    public int findBottomLeftValue(TreeNode root) {
        trav(root, 0);
        return tm.get(max).val;
    }
    
    private void trav(TreeNode n, int depth){
        if(depth>max){
            max = depth;
        }
        if(!tm.containsKey(depth)){
            tm.put(depth, n);
        }
        if(n.left != null){
            trav(n.left, depth+1);
        }
        if(n.right != null){
            trav(n.right, depth+1);
        }
    }
}