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
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        if(nums.length == 0){
            return null;
        }
        if(nums.length == 1){
            TreeNode n = new TreeNode(nums[0]);
            return n;
        }
        TreeNode root = getMid(0, nums.length-1);
        return root;

    }
    
    private TreeNode getMid(int left, int right){
        int mid = (int)Math.floor((left+(right))/2);
        TreeNode n = new TreeNode(nums[mid]);
        if(mid-left >= 1){
            n.left = getMid(left, mid-1);
        }
        else{
            n.left = null;
        }
        if(right-mid >= 1){
            n.right = getMid(mid+1, right);
        }
        else{
            n.right = null;
        }
        return n;
    }
}