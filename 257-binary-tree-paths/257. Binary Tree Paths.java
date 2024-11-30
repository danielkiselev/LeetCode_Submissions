/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if (root == null){
            return ans;
        }
            ans = getPaths(root, "");
            return ans;
        
    }

    private List<String> getPaths(TreeNode curr, String s) {
        List<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(s);
        sb.append(Integer.toString(curr.val));
        if (curr.left == null && curr.right == null) {
            String temp = sb.toString();
            ans.add(temp);
        } 
        else {
            sb.append("->");
            String temp = sb.toString();
            if (curr.left != null) {
                ans.addAll(getPaths(curr.left, temp));
            }
            if (curr.right != null) {
                ans.addAll(getPaths(curr.right, temp));
            }
        }
        return ans;
    }
}