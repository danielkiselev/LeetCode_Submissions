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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(checkHeight(root, 0) == -1){
            return false;
        }
        return true;
        
    }
    private int checkHeight(TreeNode curr, int depth){
        int left = depth;
        int right = depth;
        if(curr.left !=null){
            left = checkHeight(curr.left, depth+1);
        }
        if(curr.right !=null){
            right = checkHeight(curr.right, depth+1);
        }
        if(right == -1 || left == -1){
            return -1;
        }
        if(Math.abs(left-right)>1){
            return -1;
        }
        else if(left>right){
            return left;
        }
        return right;
        
    }
}