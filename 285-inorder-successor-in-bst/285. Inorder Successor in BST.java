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
    TreeNode p;
    LinkedHashMap<Integer,TreeNode> d = new LinkedHashMap<Integer,TreeNode>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.p = p;
        trav(root);
        TreeNode res = null;
        for(Integer key: d.keySet()){
            if(key>p.val){
                if(res == null){
                    res = d.get(key);
                }
                else if(res.val>d.get(key).val){
                    res = d.get(key);
                }
            }
        }
        return res;
        
    }
    private void trav(TreeNode n){

        if(n.left!=null){
            trav(n.left);
        }
        if(n.right!=null){
            trav(n.right);
        }
                d.put(n.val, n);
    }
}