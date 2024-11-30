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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root, null, null);
    }
    
    private boolean check(TreeNode curr, Integer min, Integer max){
        int locVal = curr.val;
        if(min != null){
            if(locVal<=min){
                return false;
            }
        }
        if(max != null){
            if(locVal>=max){
                return false;
            }
        }
        if(curr.left != null){
            if(!check(curr.left,min,curr.val)){
                return false;
            }
        }
        if(curr.right != null){
            if(!check(curr.right,curr.val,max)){
                return false;
            }
        }
        return true;
    }
}