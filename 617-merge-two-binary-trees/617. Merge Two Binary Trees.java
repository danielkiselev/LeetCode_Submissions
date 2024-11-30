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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode res = null;
        return combine(t1, t2, res);
        
    }
    
    private TreeNode combine(TreeNode t1, TreeNode t2, TreeNode res){
        Integer nodeVal = null;
        boolean valid1 = false;
        boolean valid2 = false;
        if(t1 != null){
            if(nodeVal == null){
                nodeVal = t1.val;
            }
            valid1 = true;
        }
        if(t2 != null){
            if(nodeVal == null){
                nodeVal = t2.val;
            }
            else{
                nodeVal+=t2.val;
            }
            valid2 = true;
        }
        if(nodeVal != null){
            res = new TreeNode(nodeVal);
        }
        if(res != null){
            if(valid1 && valid2){
                res.left = combine(t1.left, t2.left, res.left);
                res.right = combine(t1.right, t2.right, res.right);
            }
            else if(valid1){
                res.left = combine(t1.left, null, res.left);
                res.right = combine(t1.right, null, res.right);
            }
            else if(valid2){
                res.left = combine(null, t2.left, res.left);
                res.right = combine(null, t2.right, res.right);
            }
        }
        return res;
    }
}