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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        if(root.right == null && root.left == null){
            return root;
        }
        else{
            return trav(root);
        }
    }
    
    public TreeNode trav(TreeNode n){
        if(n.left != null){
            n.left = trav(n.left);
        }
        if(n.right != null){
            n.right = trav(n.right);
        }
        TreeNode temp = n.right;
        n.right = n.left;
        n.left = temp;
        return n;
    }
}