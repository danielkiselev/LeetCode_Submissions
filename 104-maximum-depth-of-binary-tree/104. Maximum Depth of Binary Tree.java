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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return trav(root, 1);
    }
    private int trav(TreeNode curr, int depth) {
        int max = depth;
        if(curr.left != null){
            max = trav(curr.left, depth+1);
        }
        if(curr.right != null){
            int right = trav(curr.right, depth+1);
            if(right>max){
                max = right;
            }
        }
        return max;
    }
}