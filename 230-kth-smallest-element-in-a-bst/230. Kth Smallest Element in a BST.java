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
    TreeSet<Integer> hm = new TreeSet<Integer>();
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        trav(root);
        return hm.get(k);
    }
    
    private void trav(TreeNode curr){
        if(hm.size() == k){
            return;
        }
        if(curr.left != null){
            trav(curr.left);
        }
        if(hm.size() == k){
            return;
        }
        if(curr.right != null){
            trav(curr.right);
        }
        if(hm.size() == k){
            return;
        }
        hm.add(curr.val);
    }
}