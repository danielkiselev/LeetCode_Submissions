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
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return res;
        }
        int temp = trav(root, -1);
        if(temp>res){
            res = temp; 
        }
        return res;
    }
    
    private int trav(TreeNode curr, int pVal){
        int left = 0;
        int right = 0;
        if(curr.left != null){
            left = trav(curr.left, curr.val);   
        }
        if(curr.right != null){
            right = trav(curr.right, curr.val); 
        }
        res = Math.max(res, left+right);
        int counter = 0;
        if(curr.val == pVal){
            counter = Math.max(left, right)+1;
        }
        return counter;
    }
}