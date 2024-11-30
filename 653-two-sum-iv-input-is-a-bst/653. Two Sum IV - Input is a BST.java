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
    
    public boolean findTarget(TreeNode root, int k) {
        ArrayDeque<TreeNode> toVisit = new ArrayDeque<TreeNode>();
        HashSet<Integer> target = new HashSet< Integer>();
        toVisit.push(root);
        while(toVisit.size()>0){
            TreeNode curr = toVisit.pop();
            int currV = curr.val;
            if(target.contains(currV)){
                return true;
            }
            target.add(k-currV);
            if(curr.left == null){
            }
            else{
                toVisit.push(curr.left);
            }
            if(curr.right == null){
            }
            else{
                toVisit.push(curr.right);
            }
        }
        return false;
    }
}