/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private TreeNode search(TreeNode s, TreeNode t){
        TreeNode res = null;
        if (s.val == t.val){
            if(check(s,t)){
                return s;
            }else{
                res = null;
            }
        }
        if(res == null){
            if (s.left == null){
                
            }
            else{
                res = search(s.left, t);
                if(res == null){
                    
                }
                else{
                    return res;
                }
            }
            if (s.right == null){
                
            }
            else{
                res = search(s.right, t);
            }
            return res;
        }
        return res;
    }
    
    private boolean check(TreeNode s, TreeNode t){
        boolean res = true;
        if(s.val == t.val){
            if(s.left == null || t.left == null){
                if(s.left == null && t.left == null){
                    
                }
                else{
                    return false;
                }
            }
            else{
                res = check(s.left, t.left);
            }
            if(!res){
                return false;
            }
            if(s.right == null || t.right == null){
                if(s.right == null && t.right == null){
                    
                }
                else{
                    return false;
                }
            }
            else{
                res = check(s.right, t.right);
            }
            return res;
        }
        return false;
        
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        TreeNode root = search(s,t);
        if(root == null){
            return false;
        }
        else{
            return true;
        }
        
    }
}